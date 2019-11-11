package com.thoughtworks.springboottutorial.repositories;

import com.thoughtworks.springboottutorial.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// All methods are in JPA repository, it creates a Book with a string id
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
