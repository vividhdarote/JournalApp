package com.vividhdarote.journalismApp.repository;

import com.vividhdarote.journalismApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String username);

    void deleteByUserName(String name);
}

