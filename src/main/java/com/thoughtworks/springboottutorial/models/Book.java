package com.thoughtworks.springboottutorial.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // tells Hibernate to make a table out of this class
public class Book {
    @Id // Indicates that field below is the primary key of the current entity
    private String id;
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
