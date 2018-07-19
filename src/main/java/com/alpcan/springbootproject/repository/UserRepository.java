package com.alpcan.springbootproject.repository;

import com.alpcan.springbootproject.entity.UserEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository("userDao")
@Primary
public interface UserRepository extends JpaRepository<UserEntity,Long> {



    UserEntity findByUserUsername(String userUsername);

    UserEntity findByUserUsernameAndPassword(String userUsername, String password);

    UserEntity findByKey(String key);


}
