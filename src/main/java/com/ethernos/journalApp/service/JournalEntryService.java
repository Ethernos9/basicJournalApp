package com.ethernos.journalApp.service;

import com.ethernos.journalApp.entity.JournalEntry;
import com.ethernos.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> getJournalEntryById(String id) {
        return journalEntryRepository.findById(id);
    }
    public void deleteJournalEntryById(String id) {
        journalEntryRepository.deleteById(id);
    }
}


// controller -----> Service ----> Repository


