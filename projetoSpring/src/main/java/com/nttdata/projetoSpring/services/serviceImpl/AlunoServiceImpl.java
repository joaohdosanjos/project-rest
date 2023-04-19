package com.nttdata.projetoSpring.services.serviceImpl;
import com.nttdata.projetoSpring.repository.AlunoRepository;
import com.nttdata.projetoSpring.model.AlunoEntity;
import com.nttdata.projetoSpring.services.AlunoService;
import com.nttdata.projetoSpring.validators.MinisterioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    public AlunoRepository alunoRepository;
    @Autowired
    private MinisterioValidator valid;

    @Override
    public AlunoEntity findAlunoByMatricula(String matricula) {
        return alunoRepository.findAlunoByMatricula(matricula);
    }

    @Autowired
    public List<AlunoEntity> findAll(){
        return alunoRepository.findAll();
    }

    @Override
    public boolean save(AlunoEntity aluno) {
        alunoRepository.save(aluno);
       return valid.validarAluno(aluno.getCpf());
   }

    @Override
    public void delete(AlunoEntity aluno) {
        alunoRepository.delete(aluno);
    }
}
