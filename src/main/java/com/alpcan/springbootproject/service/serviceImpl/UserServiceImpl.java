package com.alpcan.springbootproject.service.serviceImpl;

import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List findAll() {
        return userDao.findAll();
    }
}
