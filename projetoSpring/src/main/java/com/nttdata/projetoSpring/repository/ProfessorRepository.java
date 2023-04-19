package com.nttdata.projetoSpring.repository;

import com.nttdata.projetoSpring.model.DisciplinaEntity;
import com.nttdata.projetoSpring.model.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, String> {
    @Query("Select p from PROFESSOR p where p.cpf like :cpf")
    ProfessorEntity findProfessorByCpf(@Param("cpf") String cpf);

    @Query("Select p from PROFESSOR p where p.disciplina =:disciplina")
    List<ProfessorEntity> findByDisciplina(@Param("disciplina") DisciplinaEntity disciplina);
}
