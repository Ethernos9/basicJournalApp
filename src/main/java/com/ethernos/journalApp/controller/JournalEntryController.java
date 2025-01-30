package com.ethernos.journalApp.controller;

import com.ethernos.journalApp.entity.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public ResponseEntity<List<JournalEntry>> getAll() {
        return ResponseEntity.ok(new ArrayList<>(journalEntries.values()));
    }

    @PostMapping()
    public ResponseEntity<JournalEntry> addJournalEntry(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }
    @GetMapping("/id/{myId}")
    public  ResponseEntity<JournalEntry> getjournalbyId (@PathVariable long myId){
        return ResponseEntity.ok(journalEntries.get(myId));

    }
    @DeleteMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> deleteJournalEntry(@PathVariable long myId){
        return ResponseEntity.ok(journalEntries.remove(myId));
    }
    @PutMapping("/id/{myId}")
    public  ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable long myId, @RequestBody JournalEntry entry){
        return ResponseEntity.ok(journalEntries.put(myId, entry));
    }
}
