package com.ethernos.journalApp.controller;

import com.ethernos.journalApp.entity.JournalEntry;
import com.ethernos.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public ResponseEntity<List<JournalEntry>> getAll() {
//      return  journalEntryService.getAll();
        return ResponseEntity.ok(journalEntryService.getAll());
    }

    @PostMapping()
    public ResponseEntity<JournalEntry> addJournalEntry(@RequestBody JournalEntry entry) {
//        journalEntries.put(entry.getId(), entry);
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }
    @GetMapping("/id/{myId}")
    public  ResponseEntity<JournalEntry> getjournalbyId (@PathVariable String myId){
      return ResponseEntity.ok(journalEntryService.getJournalEntryById(myId).orElse(null));
//        return ResponseEntity.ok(JournalEntryService.getJournalEntryById(myId))

    }
    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntry(@PathVariable String myId){
         journalEntryService.deleteJournalEntryById(myId);
         return true;

    }
    @PutMapping("/id/{myId}")
    public  JournalEntry updateJournalEntry(@PathVariable String myId, @RequestBody JournalEntry NewEntry){
//        return ResponseEntity.ok(journalEntries.put(myId, entry));
        JournalEntry old  = journalEntryService.getJournalEntryById(myId).orElse(null);
        if (old != null) {
            old.setTitle(NewEntry.getTitle() != null && !NewEntry.getTitle().equals("")? NewEntry.getTitle(): old.getTitle());
            old.setContent(NewEntry.getContent() != null && !NewEntry.equals("")?NewEntry.getContent():old.getContent());;
        }
        journalEntryService.saveEntry(old);
      return old;

    }
}
