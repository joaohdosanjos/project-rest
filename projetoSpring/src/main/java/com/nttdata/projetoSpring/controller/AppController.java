package com.nttdata.projetoSpring.controller;

import com.nttdata.projetoSpring.model.*;
import com.nttdata.projetoSpring.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    //Anotação que realizará a injeção de dependencias
    @Autowired
    private AlunoService alunoService;

    /*
     Caso fizessemos com bean seria c/Construtor
     @Bean
     public ProfessorService professorService() {
        return new ProfessorService();
    }
    */

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private AulaService aulaService;
    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/homepage")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String homepage(@ModelAttribute("user") UserEntity userEntity) {
        String page = "";

        UserEntity user = userService.findUserByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
        if (user != null){
            System.out.println("Login feito com Sucesso");
            page ="homepage";

        } else {
            System.out.println("Email ou password incorreta");
            page ="loginSemSucesso";
        }
        return page;
    }

    /* -- ALUNOS -- */
    @GetMapping("/alunos")
    public String viewAlunosPage(Model model) {
        List<AlunoEntity> alunosList = alunoService.findAll();
        model.addAttribute("alunosList", alunosList);
        return "alunos";
    }


    @GetMapping("/criarAlunos")
    public String viewCriarAlunosPage(Model model){
        AlunoEntity aluno = new AlunoEntity();
        model.addAttribute("aluno", aluno);
        return "criarAlunos";
    }

    @PostMapping("/saveAluno")
    public String saveAluno(@ModelAttribute("aluno") AlunoEntity aluno) {
        if (alunoService.save(aluno)) {
            return "redirect:/homepage";
        } else {
            return "criarAlunosInvalido";
        }
    }

    @RequestMapping("/editAluno/{matricula}")
    public ModelAndView showEditAlunoPage(@PathVariable(name = "matricula") String matricula) {
        ModelAndView mav = new ModelAndView("editAluno");
        AlunoEntity aluno = alunoService.findAlunoByMatricula(matricula);
        mav.addObject("aluno", aluno);

        return mav;
    }

    @RequestMapping("/deleteAluno/{matricula}")
    public String deleteAluno(@PathVariable(name = "matricula") String matricula) {
        AlunoEntity aluno = alunoService.findAlunoByMatricula(matricula);

        alunoService.delete(aluno);
        return "redirect:/homepage";
    }


    /* -- PROFESSORES -- */
    @GetMapping("/criarProfessores")
    public String viewCriarProfessoresPage(Model model, Model model1){
        ProfessorEntity professor = new ProfessorEntity();
        model.addAttribute("professor", professor);

        List<DisciplinaEntity> disciplinaComboBox = disciplinaService.findAll();
        model1.addAttribute("disciplinaList", disciplinaComboBox);
        return "criarProfessores";
    }

    @PostMapping("/saveProfessor")
    public String saveProfessor(@ModelAttribute("professor") ProfessorEntity professor) {

        professorService.save(professor);
        return "redirect:/homepage";
    }

    @GetMapping("/professores")
    public String viewProfessorPage(Model model) {
        List<ProfessorEntity> professorList = professorService.findAll();
        model.addAttribute("professoresList", professorList);
        return "professores";
    }

    @RequestMapping("/editProfessores/{cpf}")
    public ModelAndView showEditProfessoresPage(@PathVariable(name = "cpf") String cpf,Model modelDisciplina) {
        ModelAndView mav = new ModelAndView("editProfessores");
        ProfessorEntity professor = professorService.findProfessorByCpf(cpf);

        List<DisciplinaEntity> disciplina = disciplinaService.findAll();
        modelDisciplina.addAttribute("disciplinaList", disciplina);

        mav.addObject("professor", professor);

        return mav;
    }

    @RequestMapping("/deleteProfessores/{cpf}")
    public String deleteProfessor(@PathVariable(name = "cpf") String cpf) {
        ProfessorEntity professor = professorService.findProfessorByCpf(cpf);

        professorService.delete(professor);
        return "redirect:/homepage";
    }

    /*  -- AULAS -- */
    @GetMapping("/aulas")
    public String viewAulasPage(Model model) {
        List<AulaEntity> aulasList = aulaService.findAll();
        model.addAttribute("aulasList", aulasList);
        return "aulas";
    }

    @GetMapping("/criarAula")
    public String viewCriarAulasPage(Model modelAula,Model modelProfessor, Model modelAluno){
        AulaEntity aula = new AulaEntity();
        modelAula.addAttribute("aula", aula);

        List<ProfessorEntity> professorList = professorService.findAll();
        modelProfessor.addAttribute("professorList", professorList);

        List<AlunoEntity> alunoComboBox = alunoService.findAll();
         modelAluno.addAttribute("alunoList", alunoComboBox);
        return "criarAula";
    }

    @PostMapping("/saveAula")
    public String saveAula(@ModelAttribute("aula") AulaEntity aula) {
         ProfessorEntity professor = professorService.findProfessorByCpf(aula.getProfessor().getCpf());
        AlunoEntity aluno = alunoService.findAlunoByMatricula(aula.getAluno().getMatricula());

        aula.setAluno(aluno);
        aula.setProfessor(professor);

        aulaService.save(aula);
        return "redirect:/homepage";
    }

    @RequestMapping("/editAula/{id}")
    public ModelAndView showEditAulaPage(@PathVariable(name = "id") Integer id,Model modelProfessor, Model modelAluno) {
        ModelAndView mav = new ModelAndView("editAula");
        AulaEntity aula = aulaService.findAulaById(id);

        List<ProfessorEntity> professor = professorService.findAll();
        modelProfessor.addAttribute("professorList", professor);

        List<AlunoEntity> alunoComboBox = alunoService.findAll();
        modelAluno.addAttribute("alunoList", alunoComboBox);


        mav.addObject("aula", aula);

        return mav;
    }

    @RequestMapping("/deleteAula/{id}")
    public String deleteAula(@PathVariable(name = "id") Integer id) {
        AulaEntity aula = aulaService.findAulaById(id);

        aulaService.delete(aula);
        return "redirect:/homepage";
    }

    /* DISCIPLINA */
    @GetMapping("/disciplinas")
    public String viewDisiciplinaPage(Model model) {
        List<DisciplinaEntity> disciplinaList = disciplinaService.findAll();
        model.addAttribute("disciplinasList", disciplinaList);
        return "disciplinas";
    }

    @GetMapping("/criarDisciplina")
    public String viewCriarDisciplinaPage(Model model){
        DisciplinaEntity disciplina = new DisciplinaEntity();
        model.addAttribute("disciplina", disciplina);

        return "criarDisciplina";
    }

    @PostMapping("/saveDisciplina")
    public String saveDisciplina(@ModelAttribute("disciplina") DisciplinaEntity disciplina) {
        if (disciplinaService.save(disciplina)){
            return "redirect:/homepage";

        } else {
            return "criarDisciplinaInvalido";
        }
    }

    @RequestMapping("/editDisciplina/{id}")
    public ModelAndView showEditDisciplinaPage(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("editDisciplina");
        DisciplinaEntity disciplina = disciplinaService.findDisciplinaById(id);
        mav.addObject("disciplina", disciplina);
        return mav;
    }

    @RequestMapping("/deleteDisciplina/{id}")
    public String deleteDisciplina(@PathVariable(name = "id") Integer id) {
        DisciplinaEntity disciplina = disciplinaService.findDisciplinaById(id);

        List<ProfessorEntity> professores = professorService.findByDisciplina(disciplina);

        for (ProfessorEntity professor: professores) {
                professor.setDisciplina(null);
        }

        professorService.saveAll(professores);

        disciplina.setProfessores(null);


        disciplinaService.delete(disciplina);
        return "redirect:/homepage";
    }


}

