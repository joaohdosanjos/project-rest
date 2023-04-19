package com.nttdata.projetoSpring.services.serviceImpl;


import com.nttdata.projetoSpring.model.DisciplinaEntity;
import com.nttdata.projetoSpring.model.ProfessorEntity;
import com.nttdata.projetoSpring.repository.ProfessorRepository;
import com.nttdata.projetoSpring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    public ProfessorRepository professorRepository;

    @Override
    public List<ProfessorEntity> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public void save(ProfessorEntity professor) {
        professorRepository.save(professor);
    }

    @Override
    public void saveAll(List<ProfessorEntity> professores) {
        professorRepository.saveAll(professores);
    }
    @Override
    public void update(ProfessorEntity professor) {
        professorRepository.save(professor);
    }

    @Override
    public void delete(ProfessorEntity professor) {
        professorRepository.delete(professor);
    }

    @Override
    public ProfessorEntity findProfessorByCpf(String cpf) {
        return professorRepository.findProfessorByCpf(cpf);
    }
    @Override
    public List<ProfessorEntity> findByDisciplina(DisciplinaEntity disciplina) {
        return professorRepository.findByDisciplina(disciplina);
    }

}
