package com.vividhdarote.journalismApp.service;

import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User name) {
        assertTrue(userService.saveNewUser(name));
    }




    @Disabled    //Use to disable the test while compiling
    @ParameterizedTest
    @CsvSource({
            "1,1,2",    //passed
            "2,11,12",  //failed
            "3,3,9"     //failed
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}






//Used to Check JournalEntries is empty or not
/*
User user = userRepository.findByUserName("Vishnu");
assertTrue(!user.getJournalEntryList().isEmpty());*/


//Used to Check User is Present or not
// assertNotNull(userRepository.findByUserName("Vividh"));


// Using CsvSource
/*@ParameterizedTest
@CsvSource({
        "Vividh",
        "Vishnu",
        "Abhijeet",
        "Rama"
})
public void testFindByUserName(String name) {
    assertNotNull(userRepository.findByUserName(name),"Failed for name: "+name);
}*/

//Using ValueSource
/*
@ParameterizedTest
@ValueSource(strings = {
        "Vividh",
        "Vishnu",
        "Abhijeet",
        "Rama"
})
public void testFindByUserName(String name) {
    assertNotNull(userRepository.findByUserName(name),"Failed for name: "+name);
}
*/


