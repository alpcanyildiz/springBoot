package com.alpcan.springbootproject.controller;


import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.model.request.UserEditRequest;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="/user",method = RequestMethod.GET)
    public List<User> listAll(){
    List <User> userList = userService.findAll();
    return userList;
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User viewUser(@PathVariable("id") long userId) {
        User user = userService.getOne(userId);

        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long userId){
        userService.deleteById(userId);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User editUserPut(@PathVariable("id") long userId,@RequestBody User updateUser){
        //User user = userService.getOne(userId);

        updateUser.setUserId(userId);
        userService.save(updateUser);
        return updateUser;

    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PATCH)
        public User editUserPatch(@PathVariable("id") long userId,@RequestBody UserEditRequest request){
        User user= userService.getOne(userId);


        user.setUserName(request.getUserName());
        user.setAddres(request.getAddres());
        user.setUserSurname(request.getUserSurname());
        user.setPassword(request.getPassword());
        user.seteMail(request.geteMail());

        userService.saveUserAndFlush(user);
        return user;
    }



}
