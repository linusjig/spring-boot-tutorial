package com.thoughtworks.springboottutorial.services;
import com.thoughtworks.springboottutorial.models.Book;
import com.thoughtworks.springboottutorial.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book){
        return bookRepository.save(book);
    }
}