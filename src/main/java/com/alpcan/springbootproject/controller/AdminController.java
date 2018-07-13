package com.alpcan.springbootproject.controller;

import com.alpcan.springbootproject.dao.RoleDao;
import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("roleDao")
    private RoleDao roleDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping("/listUser")
    public String showAllUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "listUser";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "addUser";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User user, @ModelAttribute("role") Role role){

        System.out.println(user.getUserName());
        System.out.println(user.getUserSurname());
        System.out.println(user.getPassword());
        System.out.println(user.getAddres());
        System.out.println(user.getUserID());

        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        Set<Role> roles = user.getRoles();
        if (roles == null) {
            roles = new HashSet<Role>();
        }

        roles.add(roleDao.findByRole("ADMIN"));

        System.out.println("denemem"+roleDao.findByRole("ADMIN").getRoleID());
        System.out.println(roleDao.findByRole("ADMIN").getRole());

        System.out.println(roleDao.findByRole("ADMIN").getUsers());


        user.setRoles(roles);

        userDao.save(user);

        return "redirect:/admin/listUser";
    }


    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userID") long userID, Model model){

        userDao.deleteById(userID);

        return "redirect:/admin/listUser";
    }






    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("userID") long userID,Model model){
        User user = userDao.getOne(userID);
        model.addAttribute("viewUser",user);
        return "viewUser";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam("userID") long userID,Model model){
        User user = userDao.getOne(userID);
        model.addAttribute("editUser",user);
        return "editUser";
    }

    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public String editUserPost(@ModelAttribute("editUser") User user){

        userDao.save(user);

        return "redirect:/admin/listUser";
    }


}
