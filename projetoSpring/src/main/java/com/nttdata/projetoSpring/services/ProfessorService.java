package com.nttdata.projetoSpring.services;

import com.nttdata.projetoSpring.model.DisciplinaEntity;
import com.nttdata.projetoSpring.model.ProfessorEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface ProfessorService extends Serializable {
    List<ProfessorEntity> findAll();
    void save(ProfessorEntity professor);

    void saveAll(List<ProfessorEntity> professores);

    void update(ProfessorEntity professor);
    void delete(ProfessorEntity professor);
    ProfessorEntity findProfessorByCpf(String cpf);

    List<ProfessorEntity> findByDisciplina(DisciplinaEntity disciplina);

}
