package com.vividhdarote.journalismApp.controller;

import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create_user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
