package com.alpcan.springbootproject.model;

import com.alpcan.springbootproject.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Long roleId;

    private String role;

    private Set<User> user;

    public Role(){
        user = new HashSet<>();
    }


    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
