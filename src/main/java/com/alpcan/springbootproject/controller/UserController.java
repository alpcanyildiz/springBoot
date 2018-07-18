package com.alpcan.springbootproject.controller;


import com.alpcan.springbootproject.configuration.NotificationService;
import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.model.User;
import com.alpcan.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
      model.addAttribute("userForm", new User());

        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult,Model model) {


        if (bindingResult.hasErrors()) {
            return "registration";
        }

        else if (!user.passwordMatched(user.getPassword(),user.getPasswordMatch())){
            model.addAttribute("errorMsg","Your passwords did not match.");
            return "registration";
        }

        try{
            notificationService.sendNotification(user);
        }
        catch (MailException e){
            System.out.println(e);
        }
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping("/reg")
    public String registrationKey(@RequestParam("key") String key, Model model){

        User user = userService.findByKey(key);
        user.setActive(true);

        userService.saveAndFlush(user);
        return "registrationCompleted";
    }



}
