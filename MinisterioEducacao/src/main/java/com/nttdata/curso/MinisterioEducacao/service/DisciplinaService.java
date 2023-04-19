package com.nttdata.curso.MinisterioEducacao.service;

import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;
import com.nttdata.curso.MinisterioEducacao.model.DisciplinaEntity;

import java.io.Serializable;
import java.util.List;

public interface DisciplinaService extends Serializable {

    public DisciplinaEntity validaDisciplina(DisciplinaEntity disciplina);
    DisciplinaEntity findDisciplinaById(Integer id);
    List<DisciplinaEntity> findAll();
    List<DisciplinaEntity> findByAreaAndTitulo(String area, String titulo);

    void save(DisciplinaEntity disciplina);

    void delete(DisciplinaEntity disciplina);
}
