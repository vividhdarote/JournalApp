package com.vividhdarote.journalismApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    public void testSendMail(){
        emailService.sendEmail("kumarkankam17@gmail.com"
                ,"Testing Java Mail Sender"
                ,"Hii Bro! Its my First Project");
    }
}
