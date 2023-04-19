package com.nttdata.projetoSpring.services;


import com.nttdata.projetoSpring.model.UserEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;

public interface UserService extends Serializable {

    UserEntity findUserByEmailAndPassword(String email, String pass);
}
