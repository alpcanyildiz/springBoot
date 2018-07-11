package com.alpcan.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringbootprojectApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringbootprojectApplication.class, args);
        //openHomePage();
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
    }
}
