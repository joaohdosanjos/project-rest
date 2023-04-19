package com.nttdata.curso.MinisterioEducacao.repository;

import com.nttdata.curso.MinisterioEducacao.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity,Long> {

    @Query("select a from ALUNO a where a.matricula =:matricula")
    public AlunoEntity findAlunoByMatricula(@Param("matricula") String matricula);

    @Query("select a from ALUNO a where a.cpf =:cpf")
    public AlunoEntity findAlunoByCpf(@Param("cpf") String cpf);


}
