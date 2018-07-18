package com.alpcan.springbootproject.service.impl;

import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUserUsernameAndPassword(String userUsername,String password) {
        return userDao.findByUserUsernameAndPassword(userUsername, password);
    }

    @Override
    public User findByKey(String key) {
        return userDao.findByKey(key);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    public void deleteById(Long userID) {
         userDao.deleteById(userID);
    }

    @Override
    public User getOne(Long userID) {
        return userDao.getOne(userID);
    }

    @Override
    public void saveAndFlush(User user) {
        userDao.saveAndFlush(user);
    }

}
