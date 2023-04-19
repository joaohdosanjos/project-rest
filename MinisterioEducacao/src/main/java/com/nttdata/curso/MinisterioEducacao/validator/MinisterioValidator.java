package com.nttdata.curso.MinisterioEducacao.validator;

import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;
import com.nttdata.curso.MinisterioEducacao.model.DisciplinaEntity;
import com.nttdata.curso.MinisterioEducacao.repository.AlunoRepository;
import com.nttdata.curso.MinisterioEducacao.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MinisterioValidator {
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public MinisterioValidator() {
    }

    public AlunoEntity validaAluno(AlunoEntity aluno) {
            if (aluno.getIdade() - aluno.getEscolaridade() != 5) {
                this.alunoRepository.delete(aluno);
                return null;
            } else {
                return aluno;
            }
    }

    public DisciplinaEntity validaDisciplina(DisciplinaEntity disciplinaEntity) {
       List<DisciplinaEntity> disciplinaList = disciplinaRepository.findByAreaAndTitulo(disciplinaEntity.getTitulo(), disciplinaEntity.getArea());

        for (DisciplinaEntity disciplina : disciplinaList) {
            if (disciplina != null && disciplina.getId() != disciplinaEntity.getId()) {
                this.disciplinaRepository.delete(disciplinaEntity);
                return null;
            }
        }
        return disciplinaEntity;
    }

}
