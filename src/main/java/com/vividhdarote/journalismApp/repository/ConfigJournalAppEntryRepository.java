package com.vividhdarote.journalismApp.repository;

import com.vividhdarote.journalismApp.entity.ConfigJournalAppEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfigJournalAppEntryRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}