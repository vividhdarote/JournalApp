package com.vividhdarote.journalismApp.controller;

import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.service.UserService;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/userr")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username) {
        User userInDb = userService.findByUserName(username);

        if (userInDb == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with username '" + username + "' not found.");
        }

        // Optionally update only certain fields
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());

        userService.saveEntry(userInDb);

        return ResponseEntity.status(HttpStatus.OK)
                .body("User updated successfully.");
    }


}

