package com.nttdata.curso.MinisterioEducacao.service;

import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;

import java.io.Serializable;
import java.util.List;

public interface AlunoService extends Serializable {

    AlunoEntity findAlunoByMatricula(String matricula);
    AlunoEntity findAlunoByCpf(String cpf);

    public AlunoEntity validaAluno(AlunoEntity aluno);

    List<AlunoEntity> findAll();

    void save(AlunoEntity aluno);

    void delete(AlunoEntity aluno);
}
