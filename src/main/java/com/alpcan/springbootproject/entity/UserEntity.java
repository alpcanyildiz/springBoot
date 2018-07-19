package com.alpcan.springbootproject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="users" )
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

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


    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name="userID")},
            inverseJoinColumns = {@JoinColumn(name="roleID")}
    )
    private Set<RoleEntity> roleEntities;

    public UserEntity(){

        roleEntities = new HashSet<>();
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
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


    public UserEntity(String userUsername, String userName, String userSurname, boolean active){
        this.userUsername = userUsername;
        this.userName = userName;
        this.userSurname = userSurname;
        this.active = active;
    }


    public UserEntity(String userUsername, String userName, String userSurname, String password, String passwordMatch, String addres, String eMail, boolean active, String key, Set<RoleEntity> roleEntities) {
        this.userUsername = userUsername;
        this.userName = userName;
        this.userSurname = userSurname;
        this.password = password;
        this.passwordMatch = passwordMatch;
        this.addres = addres;
        this.eMail = eMail;
        this.active = active;
        this.key = key;
        this.roleEntities = roleEntities;
    }

    public boolean passwordMatched(String p1, String p2){
        return p1.equals(p2);
    }
}

