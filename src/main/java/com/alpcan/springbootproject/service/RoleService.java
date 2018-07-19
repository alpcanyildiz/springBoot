package com.alpcan.springbootproject.service;


import com.alpcan.springbootproject.entity.RoleEntity;
import com.alpcan.springbootproject.model.Role;

public interface RoleService {

    Role findByRole(String role);
}
