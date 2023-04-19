package com.nttdata.curso.MinisterioEducacao.service.serviceImpl;


import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;
import com.nttdata.curso.MinisterioEducacao.repository.AlunoRepository;
import com.nttdata.curso.MinisterioEducacao.service.AlunoService;
import com.nttdata.curso.MinisterioEducacao.validator.MinisterioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private MinisterioValidator valid;
    @Autowired
    public AlunoRepository alunoRepository;

    @Override
    public AlunoEntity findAlunoByMatricula(String matricula) {
        return alunoRepository.findAlunoByMatricula(matricula);
    }

    @Override
    public AlunoEntity findAlunoByCpf(String cpf) {
        return alunoRepository.findAlunoByCpf(cpf);
    }

    @Autowired
    public List<AlunoEntity> findAll(){
        return alunoRepository.findAll();
    }

    @Override
    public void save(AlunoEntity aluno) {
        alunoRepository.save(aluno);
   }

    @Override
    public void delete(AlunoEntity aluno) {
        alunoRepository.delete(aluno);
    }

    @Override
    public AlunoEntity validaAluno(AlunoEntity aluno)
    {
        return valid.validaAluno(aluno);
    }

}
