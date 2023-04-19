package com.nttdata.projetoSpring.services.serviceImpl;

import com.nttdata.projetoSpring.model.UserEntity;
import com.nttdata.projetoSpring.repository.UserRepository;
import com.nttdata.projetoSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserEntity findUserByEmailAndPassword(String email, String pass) {
        return userRepository.findAllByStateAndPhase(email, pass);
    }

}
