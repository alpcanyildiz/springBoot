package com.alpcan.springbootproject.service.impl;

import com.alpcan.springbootproject.entity.RoleEntity;
import com.alpcan.springbootproject.entity.UserEntity;
import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.repository.RoleRepository;
import com.alpcan.springbootproject.repository.UserRepository;
import com.alpcan.springbootproject.service.RoleService;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List findAll() {

        List <UserEntity> userEntityList =userRepository.findAll();
        List <User> userList = new ArrayList<User>();
        for (UserEntity userEntity : userEntityList){

            User user = new User();
            user.setActive(userEntity.isActive());
            user.setKey(userEntity.getKey());
            user.setUserId(userEntity.getUserId());
            user.setAddres(userEntity.getAddres());
            user.seteMail(userEntity.geteMail());
            user.setPassword(userEntity.getPassword());
            user.setPasswordMatch(userEntity.getPasswordMatch());
            user.setUserName(userEntity.getUserName());
            user.setUserSurname(userEntity.getUserSurname());
            user.setUserUsername(userEntity.getUserUsername());
            userList.add(user);
        }

        return userList;
    }

    @Override
    public User findByUserUsernameAndPassword(String userUsername, String password) {

        UserEntity userEntity=userRepository.findByUserUsernameAndPassword(userUsername, password);

        User user = new User();
        user.setActive(userEntity.isActive());
        user.setKey(userEntity.getKey());



        user.setAddres(userEntity.getAddres());
        user.seteMail(userEntity.geteMail());
        user.setPassword(userEntity.getPassword());
        user.setPasswordMatch(userEntity.getPasswordMatch());
        user.setUserName(userEntity.getUserName());
        user.setUserSurname(userEntity.getUserSurname());
        user.setUserUsername(userEntity.getUserUsername());

        return user;
    }

    @Override
    public User findByKey(String key) {

        UserEntity userEntity=userRepository.findByKey(key);

        User user = new User();
        user.setActive(userEntity.isActive());
        user.setKey(userEntity.getKey());


        //user.setRole(userEntity.getRoleEntities());
        //user.setRole(setofRole);


        user.setAddres(userEntity.getAddres());
        user.seteMail(userEntity.geteMail());
        user.setPassword(userEntity.getPassword());
        user.setPasswordMatch(userEntity.getPasswordMatch());
        user.setUserName(userEntity.getUserName());
        user.setUserSurname(userEntity.getUserSurname());
        user.setUserUsername(userEntity.getUserUsername());
        return user;

    }

    @Override
    public UserEntity saveUserAndFlush(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(user.getUserId());
        userEntity.setActive(user.isActive());
        userEntity.setKey(user.getKey());
        // userEntity.setRoleEntities(user.getRole());

        Set<Role> roleSet = userEntity.getRoleEntities()
                .stream()
                .map(
                        e -> {
                            Role role = new Role();
                            role.setRole(e.getRole());
                            role.setRole(e.getRole());

                           // role.setUser(e.getUserEntities());

                            return role;
                        }
                ).collect(Collectors.toSet());

        user.setRole(roleSet);



        userEntity.setAddres(user.getAddres());
        userEntity.seteMail(user.geteMail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPasswordMatch(user.getPasswordMatch());
        userEntity.setUserName(user.getUserName());
        userEntity.setUserSurname(user.getUserSurname());
        userEntity.setUserUsername(user.getUserUsername());


        //user => userEntity

        //uset.x = userEntity.x


        return userRepository.saveAndFlush(userEntity);
    }


    public void save(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserId(user.getUserId());
        userEntity.setActive(user.isActive());
        userEntity.setKey(user.getKey());
       // userEntity.setRoleEntities(user.getRole());
        userEntity.setAddres(user.getAddres());
        userEntity.seteMail(user.geteMail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPasswordMatch(user.getPasswordMatch());
        userEntity.setUserName(user.getUserName());
        userEntity.setUserSurname(user.getUserSurname());
        userEntity.setUserUsername(user.getUserUsername());



        userRepository.save(userEntity);
    }


    @Override
    public void deleteById(Long userID) {
         userRepository.deleteById(userID);
    }

    @Override
    public User getOne(Long userID) {
        User user = new User();
        UserEntity userEntity = userRepository.getOne(userID);
        user.setUserId(userEntity.getUserId());
        user.setActive(userEntity.isActive());
        user.setKey(userEntity.getKey());
        //user.setRole(userEntity.getRoleEntities());
        user.setAddres(userEntity.getAddres());
        user.seteMail(userEntity.geteMail());
        user.setPassword(userEntity.getPassword());
        user.setPasswordMatch(userEntity.getPasswordMatch());
        user.setUserName(userEntity.getUserName());
        user.setUserSurname(userEntity.getUserSurname());
        user.setUserUsername(userEntity.getUserUsername());

        return user;
    }


}
