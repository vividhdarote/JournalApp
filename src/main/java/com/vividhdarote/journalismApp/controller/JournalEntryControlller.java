package com.vividhdarote.journalismApp.controller;

import com.vividhdarote.journalismApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControlller {

    private Map<Long, JournalEntry> journalEntry = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){   //localhost:8080/journal GET
        return new ArrayList<>(journalEntry.values());
        
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){    //localhost:8080/journal  POST
        journalEntry.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntry.get(myId);
    }

    @DeleteMapping ("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntry.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntry.put(id,myEntry);
    }
}
