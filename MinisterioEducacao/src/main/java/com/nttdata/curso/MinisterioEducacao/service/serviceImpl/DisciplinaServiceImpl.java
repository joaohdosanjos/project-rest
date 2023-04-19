package com.nttdata.curso.MinisterioEducacao.service.serviceImpl;


import com.nttdata.curso.MinisterioEducacao.model.DisciplinaEntity;
import com.nttdata.curso.MinisterioEducacao.repository.DisciplinaRepository;
import com.nttdata.curso.MinisterioEducacao.service.DisciplinaService;
import com.nttdata.curso.MinisterioEducacao.validator.MinisterioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    public DisciplinaRepository disciplinaRepository;
    @Autowired
    private MinisterioValidator valid;

    @Override
    public List<DisciplinaEntity> findAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public void save(DisciplinaEntity disciplina) {
        disciplinaRepository.save(disciplina);
    }

    @Override
    public void delete(DisciplinaEntity disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    @Override
    public DisciplinaEntity validaDisciplina(DisciplinaEntity disciplina) {
            return valid.validaDisciplina(disciplina);
        }
    @Override
    public  List<DisciplinaEntity> findByAreaAndTitulo(String area, String titulo){
        return disciplinaRepository.findByAreaAndTitulo(area, titulo);
    }
    @Override
    public DisciplinaEntity findDisciplinaById(Integer id){
        return disciplinaRepository.findDisciplinaById(id);
    }
}
