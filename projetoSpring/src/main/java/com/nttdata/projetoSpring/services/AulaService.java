package com.nttdata.projetoSpring.services;

import com.nttdata.projetoSpring.model.AulaEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public interface AulaService extends Serializable {

    AulaEntity findAulaById(Integer id);
    List<AulaEntity> findAll();

    void save(AulaEntity aula);

    void delete(AulaEntity aula);

}
