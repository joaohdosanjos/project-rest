package com.nttdata.projetoSpring.repository;

import com.nttdata.projetoSpring.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity,String> {

    @Query("select a from ALUNO a where a.matricula =:matricula")
    public AlunoEntity findAlunoByMatricula(@Param("matricula") String matricula);


}
