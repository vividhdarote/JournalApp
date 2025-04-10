package com.vividhdarote.journalismApp.service;


import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void saveEntry(User user) {
        userRepository.save(user);
    }


    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
