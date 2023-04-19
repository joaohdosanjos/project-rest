package com.nttdata.projetoSpring.services;

import com.nttdata.projetoSpring.model.AlunoEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public interface AlunoService extends Serializable {
    AlunoEntity findAlunoByMatricula(String matricula);
    List<AlunoEntity> findAll();
    boolean save(AlunoEntity aluno);

    void delete(AlunoEntity aluno);
}
