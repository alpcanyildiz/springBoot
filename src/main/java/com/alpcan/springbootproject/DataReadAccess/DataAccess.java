package com.alpcan.springbootproject.DataReadAccess;

import com.alpcan.springbootproject.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataAccess {


    public List<User> readFile (MultipartFile file){


        BufferedReader br;

        List<User> userList = new ArrayList<>();


        try {
            String line;

            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(",");
                User user = new User(lineArray[0],lineArray[1],lineArray[2],true,Float.parseFloat(lineArray[3]));
                userList.add(user);

            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return userList;


    }



}
