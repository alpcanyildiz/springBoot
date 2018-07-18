package com.alpcan.springbootproject.DataReadAccess;

import com.alpcan.springbootproject.dao.AccountDao;
import com.alpcan.springbootproject.entity.BankAccount;
import com.alpcan.springbootproject.model.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DataAccess {


    @Autowired
    private AccountDao accountDao;

    public List<BankAccount> readFile (MultipartFile file) throws ParseException {

        BufferedReader br;
        List<BankAccount> bankAccountList = new ArrayList<>();

        SimpleDateFormat parser =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(",");
                //User user = new User(lineArray[0],lineArray[1],lineArray[2],true,Float.parseFloat(lineArray[3]));

                BankAccount bankAccount = new BankAccount();


                bankAccount.setFromID(lineArray[0]);
                bankAccount.setToID(lineArray[1]);
                bankAccount.setBalance(Float.parseFloat(lineArray[2]));

                Date date = parser.parse(lineArray[3]);
                bankAccount.setDate(date);

                bankAccount.setFormattedDate(parser.format(date));

                bankAccountList.add(bankAccount);


            }

        } catch (IOException e) {
            return null;
        }

        return bankAccountList;

    }





    public void readFile2 (MultipartFile file) throws ParseException {

        BufferedReader br;


        SimpleDateFormat parser =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(",");
                //User user = new User(lineArray[0],lineArray[1],lineArray[2],true,Float.parseFloat(lineArray[3]));

                BankAccount bankAccount = new BankAccount();
                //bankAccount.setFromID(Long.parseLong(lineArray[0]));
                bankAccount.setToID(lineArray[1]);
                bankAccount.setBalance(Float.parseFloat(lineArray[2]));


                Date date = parser.parse(lineArray[3]);
                bankAccount.setDate(date);

                accountDao.save(bankAccount);

            }

        } catch (IOException e) {
            System.out.println(e);
        }


    }



}
