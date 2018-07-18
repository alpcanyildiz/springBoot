package com.alpcan.springbootproject.controller;


import com.alpcan.springbootproject.dao.AccountDao;
import com.alpcan.springbootproject.entity.BankAccount;
import com.alpcan.springbootproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RequestMapping("/account")
@Controller
//    @RestController

    public class AccountDocumentController {


    @Autowired
    private AccountService accountService;


       @RequestMapping("/list")
        public String listAllDocument(Model model){

           model.addAttribute("documents",accountService.findAll());
           return "accDocument";
    }

    @RequestMapping(value = "/listAccount",method = RequestMethod.GET)
    public String listAnAccount(Model model, HttpServletRequest request){

        String id = request.getParameter("accountID");
        String time = request.getParameter("time");


        Date date = findCorrectDate(time);

        model.addAttribute("documentbyID",accountService.findByDateGreaterThanAndFromID(date,id));
        model.addAttribute("accountInformation",id);

        model.addAttribute("timeInformation",time);
        return "specificDocument";
    }


    //   @RequestMapping(value = {"/showJson"})
    //    public List<BankAccount> listAll(){
    //      return accountDao.findAll();
    //    }

    //   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    //    public BankAccount listID(@PathVariable(value = "id") Long id){

    //        return accountDao.getOne(id);

    //    }


    public Date findCorrectDate(String time){

        Date date = new Date();

        if (time.equals("")){
            int month=date.getMonth(); //Default
            month--;
            date.setMonth(month);
        }
        else if (time.equals("lastday")){
            int day= date.getDay();
            day--;
            }
        else if (time.equals("lastweek")){
            int day= date.getDay();

        }
        else if (time.equals("lastmonth")){
            int month=date.getMonth(); //Bunun daha iyi bir yöntemi olmalı
            month--;
            date.setMonth(month);

        }
        else if (time.equals("lastyear")){
            int year=date.getYear(); //Bunun daha iyi bir yöntemi olmalı
            year--;
            date.setYear(year);
        }

        return date;
    }

}
