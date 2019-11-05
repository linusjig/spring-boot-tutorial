package com.thoughtworks.springboottutorial.controllers;

import com.thoughtworks.springboottutorial.models.Book;
import com.thoughtworks.springboottutorial.services.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// MockMvcResultMatchers.* provides a number of expectations, some of which are further nested with more detailed expectations.
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void should_return_ok__and_location_when_creating_books() throws Exception {
        String title = "The Unbearable Lightness of Being";
        String author = "Milan Kundera";

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        Book createdBook = new Book();
        createdBook.setTitle(title);
        createdBook.setAuthor(author);
        createdBook.setId("id1");

        when(bookService.create(refEq(book))).thenReturn(createdBook);


        mockMvc.perform(post("/books")
            .accept(MediaType.APPLICATION_JSON)
            .param("title", title)
            .param("author", author))
            .andExpect(status().isCreated())
            .andExpect(header().string("location", containsString("/books/id1")));
    }
}
