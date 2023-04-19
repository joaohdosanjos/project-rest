package com.nttdata.projetoSpring.services.serviceImpl;


import com.nttdata.projetoSpring.model.AulaEntity;
import com.nttdata.projetoSpring.repository.AulaRepository;
import com.nttdata.projetoSpring.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    public AulaRepository aulaRepository;

    @Override
    public AulaEntity findAulaById(Integer id) {
        return aulaRepository.findAulaById(id);
    }

    @Autowired
    public List<AulaEntity> findAll(){
        return aulaRepository.findAll();
    }

    @Override
    public void save(AulaEntity aula) {
        aulaRepository.save(aula);
   }

    @Override
    public void delete(AulaEntity aula) {
        aulaRepository.delete(aula);
    }
}
