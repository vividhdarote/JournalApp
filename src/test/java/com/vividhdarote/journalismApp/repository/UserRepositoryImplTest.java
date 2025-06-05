package com.vividhdarote.journalismApp.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepository;


    @Disabled
    @Test
    public void testSaveNewUser(){
        Assertions.assertNotNull(userRepository.getUserForSA());
    }

}
