package com.thoughtworks.springboottutorial.controllers;
import com.thoughtworks.springboottutorial.models.Book;
import com.thoughtworks.springboottutorial.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity create(
      UriComponentsBuilder uriComponentsBuilder,
      @RequestParam String title,
      @RequestParam(required = false) String author) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        Book createdBook = bookService.create(book);

        UriComponents uriComponents =
                uriComponentsBuilder.path("books/{id}").buildAndExpand(createdBook.getId());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}