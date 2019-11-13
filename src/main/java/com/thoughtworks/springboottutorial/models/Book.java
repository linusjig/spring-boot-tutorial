package com.thoughtworks.springboottutorial.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity // tells Hibernate to make a table out of this class
public class Book {
    @Id // Indicates that field below is the primary key of the current entity
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
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

    // Instead of using refEq in ControllerTest, we can override the way the object is tested for equality
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(title, book.title) &&
//                Objects.equals(author, book.author);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, author);
//    }
}
