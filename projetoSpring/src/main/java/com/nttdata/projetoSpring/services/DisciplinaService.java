package com.nttdata.projetoSpring.services;

import com.nttdata.projetoSpring.model.DisciplinaEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface DisciplinaService extends Serializable {

    DisciplinaEntity findDisciplinaById(Integer id);
    List<DisciplinaEntity> findAll();

    boolean save(DisciplinaEntity disciplina);

    void delete(DisciplinaEntity disciplina);
}
