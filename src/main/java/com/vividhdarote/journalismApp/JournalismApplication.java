package com.vividhdarote.journalismApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class JournalismApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalismApplication.class, args);

	}

	@Bean
	public PlatformTransactionManager falana(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

}