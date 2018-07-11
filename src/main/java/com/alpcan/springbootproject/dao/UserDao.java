package com.alpcan.springbootproject.dao;

import com.alpcan.springbootproject.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
@Primary
public interface UserDao extends JpaRepository<User,Long> {



    User findByUserUsername(String userUsername);

    User findByUserUsernameAndPassword(String userUsername,String password);

    User findByKey(String key);


}
