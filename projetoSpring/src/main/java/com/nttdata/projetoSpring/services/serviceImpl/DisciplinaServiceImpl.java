package com.nttdata.projetoSpring.services.serviceImpl;


import com.nttdata.projetoSpring.model.DisciplinaEntity;
import com.nttdata.projetoSpring.repository.DisciplinaRepository;
import com.nttdata.projetoSpring.services.DisciplinaService;
import com.nttdata.projetoSpring.validators.MinisterioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    public DisciplinaRepository disciplinaRepository;
    @Autowired
    public MinisterioValidator valid;

    @Override
    public List<DisciplinaEntity> findAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public boolean save(DisciplinaEntity disciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaRepository.save(disciplina);

        return valid.validarDisciplina(disciplinaEntity.getId());
    }

    @Override
    public void delete(DisciplinaEntity disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    @Override
    public DisciplinaEntity findDisciplinaById(Integer id){
        return disciplinaRepository.findDisciplinaById(id);
    }
}
