package com.vividhdarote.journalismApp.service;

import com.vividhdarote.journalismApp.model.SentimentData;
import org.springframework.beans.factory.annotation.Autowired;

public class SentimentConsumerService {

    @Autowired
    private EmailService emailService;

    private void sendEmail(SentimentData sentimentData){
        emailService.sendEmail(sentimentData.getEmail(),"Sentiment for previous week", sentimentData.getSentiment());
    }
}
