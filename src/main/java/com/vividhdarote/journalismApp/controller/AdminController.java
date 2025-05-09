package com.vividhdarote.journalismApp.controller;


import com.vividhdarote.journalismApp.config.SpringSecurity;
import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SpringSecurity security;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        try{
            List<User> all = userService.getAll();
            if (all != null && !all.isEmpty()) {
                return new ResponseEntity<>(all, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Something went wrong while fetching users.");
        }

    }

    @PostMapping("/create-admin-user")
    public void createAdminUser(@RequestBody User user){
        userService.saveAdmin(user);
    }
}
