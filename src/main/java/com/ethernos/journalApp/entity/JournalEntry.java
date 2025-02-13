package com.ethernos.journalApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private String id;

    private String title;

    private String author;

    private String content;

    private LocalDateTime date ;


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public  String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getContent(){
        return content;

    }
    public void setContent(String content){
        this.content = content;
    }
}
