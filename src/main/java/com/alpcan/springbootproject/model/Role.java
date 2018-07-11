package com.alpcan.springbootproject.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue
    private Long roleID;

    private String role;

    @ManyToMany( mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    private Role(){} //


    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
