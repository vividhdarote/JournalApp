package com.vividhdarote.journalismApp.controller;

import com.vividhdarote.journalismApp.api.response.WeatherResponse;
import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.repository.UserRepository;
import com.vividhdarote.journalismApp.service.UserService;
import com.vividhdarote.journalismApp.service.WeatherService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/userr")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUserName(username);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userInDb.setEmail(user.getEmail());
        userInDb.setCity(user.getCity());

        userService.saveNewUser(userInDb);

        return ResponseEntity.status(HttpStatus.OK)
                .body("User updated successfully.");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //Weather API
    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User userInDB = userService.findByUserName(username);
        if(userInDB == null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        WeatherResponse weatherResponse = weatherService.getWeather(userInDB.getCity());
        String greeting = "";
        if (weatherResponse != null) {
            greeting = "! "+weatherResponse.getLocation().getName()+", "+weatherResponse.getLocation().getCountry()+" Temperature goes to " + weatherResponse.getCurrent().getTemperature();
        }
        return new ResponseEntity<>("Hi " + username + greeting, HttpStatus.OK);
    }
}




