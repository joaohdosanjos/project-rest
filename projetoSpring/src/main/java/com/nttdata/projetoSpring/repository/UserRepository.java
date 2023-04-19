package com.nttdata.projetoSpring.repository;

import com.nttdata.projetoSpring.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("select u from USER u where u.email =:email AND u.password =:pass")
    public UserEntity findAllByStateAndPhase(@Param("email") String email, @Param("pass") String pass);
}
