package com.vividhdarote.journalismApp.controller;

import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.repository.UserRepository;
import com.vividhdarote.journalismApp.service.UserService;
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

/*    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }*/



    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUserName(username);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());

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

}

