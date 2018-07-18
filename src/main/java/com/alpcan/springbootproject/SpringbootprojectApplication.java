package com.alpcan.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@SpringBootApplication
public class SpringbootprojectApplication {

    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(SpringbootprojectApplication.class, args);
        //openHomePage();

        SimpleDateFormat parser =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String deneme = "31-12-2018 23:00:15" ;

        Date date = parser.parse(deneme);


        System.out.println(date);
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
    }
}
