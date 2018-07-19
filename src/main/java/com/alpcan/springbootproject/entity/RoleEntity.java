package com.alpcan.springbootproject.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class RoleEntity {

    @Id
    @GeneratedValue
    private Long roleId;

    private String role;

    @ManyToMany( mappedBy = "roleEntities")

    private Set<UserEntity> userEntities ;


    public RoleEntity(){
        userEntities = new HashSet<>();
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

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

}
