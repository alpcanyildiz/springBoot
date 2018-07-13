package com.alpcan.springbootproject.model;

import com.alpcan.springbootproject.dao.RoleDao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table( name="users" )
public class User {


    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    //  @NotNull(message = "Username text are must not be empty !")
    private String userUsername;


   // @NotNull(message = "Name text are must not be empty !")
    private String userName;
    //  @NotNull(message = "Surname text are must not be empty !")
    private String userSurname;

    //  @NotNull(message = "Please choose a password")
    private String password;

    //  @NotNull(message = "Please choose a password")
    @Transient
    private String passwordMatch;

    // @NotNull(message = "Give adress please")
    private String addres;
    // @Email(message = "Please enter valid e mail.")

    private String eMail;

    private boolean active = false;

    private String key;

    private float balanced;


    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name="userID")},
            inverseJoinColumns = {@JoinColumn(name="roleID")}
    )
    private Set<Role> roles = new HashSet<Role>();




    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /* public void setRoles(Set<String> roleNames) {

       final Set<Role> roles1 = roleNames.stream()
               .map(
               .collect(Collectors.toSet());

       this.roles = roles1;
    } */

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public float getBalanced() {
        return balanced;
    }

    public void setBalanced(float balanced) {
        this.balanced = balanced;
    }

    public User( String userUsername,String userName,String userSurname, boolean active,float money){
        this.userUsername = userUsername;
        this.userName = userName;
        this.userSurname = userSurname;
        this.active = active;
        this.balanced=money;
    }


    public User(String userUsername, String userName, String userSurname, String password, String passwordMatch, String addres, String eMail, boolean active, String key, Set<Role> roles) {
        this.userUsername = userUsername;
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.passwordMatch = passwordMatch;
        this.addres = addres;
        this.eMail = eMail;
        this.active = active;
        this.key = key;
        this.roles = roles;
    }

    public boolean passwordMatched(String p1, String p2){
        return p1.equals(p2);
    }
}

