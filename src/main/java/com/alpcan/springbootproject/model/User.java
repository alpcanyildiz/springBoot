package com.alpcan.springbootproject.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long userId;

    //@NotNull(message = "Username text are must not be empty !")
    private String userUsername;


    @NotEmpty(message = "Name must not be empty !")
    private String userName;
    //  @NotNull(message = "Surname text are must not be empty !")
    private String userSurname;

    //  @NotNull(message = "Please choose a password")
    private String password;

    //  @NotNull(message = "Please choose a password")
    private String passwordMatch;

    // @NotNull(message = "Give adress please")
    private String addres;
    // @Email(message = "Please enter valid e mail.")

    private String eMail;

    private boolean active = false;

    private String key;

    private Set<Role> role ;


    public User(){
        role = new HashSet<>();

    }


    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getUserId() {
        return userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatch() {
        return passwordMatch;
    }

    public void setPasswordMatch(String passwordMatch) {
        this.passwordMatch = passwordMatch;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
