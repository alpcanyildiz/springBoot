package com.alpcan.springbootproject.controller;

import com.alpcan.springbootproject.dao.RoleDao;
import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.model.Role;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.service.RoleService;
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

import java.util.HashSet;
import java.util.Set;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {



    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



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

        Set<Role> roles = user.getRoles();
        if (roles == null) {
            roles = new HashSet<Role>();
        }

        roles.add(roleService.findByRole("ADMIN"));
        user.setRoles(roles);
        userService.save(user);

        return "redirect:/admin/listUser";
    }


    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userID") long userID, Model model){

        userService.deleteById(userID);

        return "redirect:/admin/listUser";
    }


    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("userID") long userID,Model model){
        User user = userService.getOne(userID);
        model.addAttribute("viewUser",user);
        return "viewUser";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam("userID") long userID,Model model){
        User user = userService.getOne(userID);
        model.addAttribute("editUser",user);
        return "editUser";
    }

    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    public String editUserPost(@ModelAttribute("editUser") User user){
        userService.save(user);
        return "redirect:/admin/listUser";
    }


}
