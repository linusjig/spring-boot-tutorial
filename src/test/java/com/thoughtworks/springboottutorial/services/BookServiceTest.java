package com.thoughtworks.springboottutorial.services;

import com.thoughtworks.springboottutorial.models.Book;
import com.thoughtworks.springboottutorial.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class BookServiceTest {
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void setBookService(){
        initMocks(bookRepository);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void shouldCreateBook() {
        String title = "The Unbearable Lightness of Being";
        String author = "Milan Kundera";

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setId("id1");

        when(bookRepository.save(refEq(book))).thenReturn(newBook);

        Book createdBook = bookService.create(book);

        assertThat(createdBook.getId(), is("id1"));
        assertThat(createdBook.getTitle(), is(title));
        assertThat(createdBook.getAuthor(), is(author));
    }
}
