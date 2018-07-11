package com.alpcan.springbootproject.configuration;

import com.alpcan.springbootproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendNotification(User user)throws MailException {

        String key = generateString();

        user.setKey(key);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.geteMail());
        mailMessage.setFrom("bootspring1@gmail.com");
        mailMessage.setSubject("Registration Complete");
        mailMessage.setText("You need to verify your account by clicking: \n \n" +
                "http://localhost:8080/reg?key="+key
        );

        javaMailSender.send(mailMessage);

    }


    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }




}
