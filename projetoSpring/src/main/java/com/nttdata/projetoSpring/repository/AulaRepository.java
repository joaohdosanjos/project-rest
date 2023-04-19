package com.nttdata.projetoSpring.repository;

import com.nttdata.projetoSpring.model.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity,Long> {
    @Query("select a from AULA a where a.id =:id")
    public AulaEntity findAulaById(@Param("id") Integer id);
}
