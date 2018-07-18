package com.alpcan.springbootproject.service.impl;


import com.alpcan.springbootproject.dao.RoleDao;
import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByRole(String role) {
        return roleDao.findByRole(role);
    }
}
