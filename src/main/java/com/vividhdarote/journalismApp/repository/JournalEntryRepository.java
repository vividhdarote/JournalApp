package com.vividhdarote.journalismApp.repository;

import com.vividhdarote.journalismApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    

}
