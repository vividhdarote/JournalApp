package com.vividhdarote.journalismApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//@EnableTransactionManagement
public class JournalismApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalismApplication.class, args);

	}

}