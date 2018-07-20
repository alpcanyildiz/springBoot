package com.alpcan.springbootproject.datareadaccess;

import com.alpcan.springbootproject.model.BankAccount;
import com.alpcan.springbootproject.repository.AccountRepository;
import com.alpcan.springbootproject.entity.BankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DataAccess {


    @Autowired
    private AccountRepository accountRepository;

    public List<BankAccount> readFile (MultipartFile file) throws ParseException {

        BufferedReader br;
        List<BankAccount> bankAccountList = new ArrayList<>();

        //SimpleDateFormat parser =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time ="31-12-2018 23:00:15";


        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] lineArray = line.split(",");

                BankAccount bankAccount = new BankAccount();


                bankAccount.setFromId(lineArray[0]);
                bankAccount.setToId(lineArray[1]);
                bankAccount.setBalance(Float.parseFloat(lineArray[2]));


                ZonedDateTime date = LocalDateTime.parse(lineArray[3],dtf).atZone(ZoneId.of("Asia/Istanbul"));

                bankAccount.setDate(date);
                bankAccount.setFormattedDate(dtf.format(date));

                bankAccountList.add(bankAccount);


            }

        } catch (IOException e) {
            return null;
        }

        return bankAccountList;

    }





    public void readFile2 (MultipartFile file) throws ParseException {

        BufferedReader br;



        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(",");
                //UserEntity user = new UserEntity(lineArray[0],lineArray[1],lineArray[2],true,Float.parseFloat(lineArray[3]));

                BankAccountEntity bankAccountEntity = new BankAccountEntity();
                //bankAccountEntity.setFromID(Long.parseLong(lineArray[0]));
                bankAccountEntity.setToId(lineArray[1]);
                bankAccountEntity.setBalance(Float.parseFloat(lineArray[2]));

                ZonedDateTime date = LocalDateTime.parse(lineArray[3],dtf).atZone(ZoneId.of("Asia/Istanbul"));

                bankAccountEntity.setDate(date);
                bankAccountEntity.setFormattedDate(dtf.format(date));



                accountRepository.save(bankAccountEntity);

            }

        } catch (IOException e) {
            System.out.println(e);
        }


    }



}
