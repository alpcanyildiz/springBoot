package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.entity.UserEntity;
import com.alpcan.springbootproject.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUserUsernameAndPassword(String userUsername, String password);

    User findByKey(String key);  //UserEntity'den User'a çevirdim

    UserEntity saveUserAndFlush(User user);

     void save(User user);

     void deleteById(Long userID);

     User getOne(Long userID); //UserEntity'den User'a çevirdim

    // public void saveAndFlush(UserEntity userEntity);
}
