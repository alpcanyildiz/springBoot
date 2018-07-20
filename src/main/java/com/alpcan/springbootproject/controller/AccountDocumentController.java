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

        ZonedDateTime date = findCorrectDate(request.getTime());

        List<BankAccount> accounts = accountService.findByDateGreaterThanAndFromId(date, request.getAccountID());

        if(accounts==null){
            //Burda throw Excp.
            System.out.println();
        }

        model.addAttribute("documentbyID", accounts);
        model.addAttribute("accountInformation", request.getAccountID());

        model.addAttribute("timeInformation", request.getTime());

        return "specificDocument";
    }



        private ZonedDateTime findCorrectDate(String time){

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

            switch (time) {
                case "":
                    return zonedDateTime.minusMonths(1);
                case "lastday":
                    return zonedDateTime.minusDays(1);
                case "lastweek":
                    return zonedDateTime.minusWeeks(1);
                case "lastmonth":
                    return zonedDateTime.minusMonths(1);
                case "lastyear":
                    return zonedDateTime.minusYears(1);
            }
        return zonedDateTime;
    }

}
