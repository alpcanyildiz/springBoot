package com.alpcan.springbootproject.service.impl;


import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.repository.RoleRepository;
import com.alpcan.springbootproject.entity.RoleEntity;
import com.alpcan.springbootproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
