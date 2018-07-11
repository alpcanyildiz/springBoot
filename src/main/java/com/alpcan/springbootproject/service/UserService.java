package com.alpcan.springbootproject.service;

import com.alpcan.springbootproject.model.User;

import java.util.List;

public interface UserService {
    List findAll();

    User findByUserUsernameAndPassword(String userUsername, String password);

    User findByKey(String key);

    User saveUser(User user);
}
