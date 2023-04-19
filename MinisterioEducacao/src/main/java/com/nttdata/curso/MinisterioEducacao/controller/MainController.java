package com.nttdata.curso.MinisterioEducacao.controller;

import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;
import com.nttdata.curso.MinisterioEducacao.model.DisciplinaEntity;
import com.nttdata.curso.MinisterioEducacao.service.AlunoService;
import com.nttdata.curso.MinisterioEducacao.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping(path = "/getAluno/{cpf}", method = RequestMethod.GET)
    public AlunoEntity validaAluno(@PathVariable String cpf){
        return alunoService.validaAluno(alunoService.findAlunoByCpf(cpf));
    }

    @RequestMapping(path = "/getDisciplina/{id}", method = RequestMethod.GET)
    public DisciplinaEntity validaAluno(@PathVariable Integer id){
        return disciplinaService.validaDisciplina(disciplinaService.findDisciplinaById(id));
    }
}
