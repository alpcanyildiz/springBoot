package com.alpcan.springbootproject.controller;


import com.alpcan.springbootproject.DataReadAccess.DataAccess;
import com.alpcan.springbootproject.dao.AccountDao;
import com.alpcan.springbootproject.dao.UserDao;
import com.alpcan.springbootproject.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

@Controller
public class UploadFileController {

    @Autowired
    private DataAccess dataAccess;

    @Autowired
    private UserDao userDao;


    @Autowired
    private AccountDao accountDao;


    @GetMapping("/upload")
    public String index() {

        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws ParseException {

        long startTime = System.currentTimeMillis();

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/upload";
        }

        List<BankAccount> bankAccountList = dataAccess.readFile(file);

        if  (bankAccountList == null){

            redirectAttributes.addFlashAttribute("message", "File "+ file.getOriginalFilename() + "is broken");
            return "redirect:/upload";
        }


        accountDao.saveAll(bankAccountList);

        //dataAccess.readFile2(file);

        redirectAttributes.addFlashAttribute("message", "File "+ file.getOriginalFilename()+ " Succesfully Added");

        long endTime = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");

        String duration = formatter.format((endTime - startTime) / 1000d);

        redirectAttributes.addFlashAttribute("time","It takes :" + duration + " \n seconds to save to database");
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }



}
