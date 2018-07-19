package com.alpcan.springbootproject.controller;


import com.alpcan.springbootproject.entity.BankAccountEntity;
import com.alpcan.springbootproject.model.BankAccount;
import com.alpcan.springbootproject.model.request.GetAccountsRequest;
import com.alpcan.springbootproject.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@RequestMapping("/account")
@Controller
//    @RestController

    public class AccountDocumentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDocumentController.class);


    @Autowired
    private AccountService accountService;


       @RequestMapping("/list")
        public String listAllDocument(Model model){
            LOGGER.info("Going to list all Account Documents");

            List<BankAccount> bankAccountList = accountService.findAll();
           model.addAttribute("documents",bankAccountList);
           return "accDocument";
    }



    @RequestMapping(value = "/listAccount",method = RequestMethod.GET)
    public String listAnAccount(Model model, GetAccountsRequest request){

        Date date = findCorrectDate(request.getTime());

        List<BankAccount> accounts = accountService.findByDateGreaterThanAndFromId(date, request.getAccountID());

        model.addAttribute("documentbyID", accounts);
        model.addAttribute("accountInformation", request.getAccountID());

        model.addAttribute("timeInformation", request.getTime());

        return "specificDocument";
    }


    //   @RequestMapping(value = {"/showJson"})
    //    public List<BankAccountEntity> listAll(){
    //      return accountDao.findAll();
    //    }

    //   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    //    public BankAccountEntity listID(@PathVariable(value = "id") Long id){

    //        return accountDao.getOne(id);

    //    }


   // ZonedDateTime

    public Date findCorrectDate(String time){

        //ZonedDateTime date = ZonedDateTime.now();

        Date date = new Date();
        //date.minusHours(2)

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
