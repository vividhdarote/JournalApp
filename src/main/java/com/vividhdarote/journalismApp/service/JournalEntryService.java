package com.vividhdarote.journalismApp.service;

import com.vividhdarote.journalismApp.entity.JournalEntry;
import com.vividhdarote.journalismApp.entity.User;
import com.vividhdarote.journalismApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user= userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntryList().add(saved);
            userService.saveEntry(user);
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the data: "+e);
        }
    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName){
        User user= userService.findByUserName(userName);
        user.getJournalEntryList().removeIf(x-> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }

}