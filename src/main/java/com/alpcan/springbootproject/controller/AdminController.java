package com.alpcan.springbootproject.controller;

import com.alpcan.springbootproject.entity.RoleEntity;
import com.alpcan.springbootproject.entity.UserEntity;
import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.model.request.UserEditRequest;
import com.alpcan.springbootproject.service.RoleService;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Secured("ROLE_ADMIN")
@Controller
public class AdminController {



    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



    @RequestMapping("/user")
    public String showAllUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "listUser";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User user){

        Set<Role> role = user.getRole();
        if (role == null) {
            role = new HashSet<Role>();
        }

        //role.add(roleService.findByRole("ADMIN"));
        //userEntity.setRoleEntities(roleEntities);

        userService.save(user);

        return "redirect:/admin/listUser";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") long userId, Model model){

        userService.deleteById(userId);

        return "redirect:/admin/listUser";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User viewUser(@PathVariable("id") long userId, Model model){
        User user = userService.getOne(userId);
        model.addAttribute("viewUser", user);
        return user;
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") long userId,Model model){
        User user= userService.getOne(userId);
        model.addAttribute("editUser", user);
        return "editUser";
    }

  //  @RequestMapping(value = "/user/{id}",method = RequestMethod.PATCH)
  //  public User editUser(PathVariable("id") long userId,
  //                             @RequestBody UserEditRequest request){

  //      User user =  userService.getOne(userId);

  //      user.setUserName(request.getUserSurname());

  //      ......

  //      userService.save(user);

  //      return user;
  //  }


}
