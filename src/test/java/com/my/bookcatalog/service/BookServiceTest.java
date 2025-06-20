package com.my.bookcatalog.service;

import com.my.bookcatalog.builder.BookBuilder;
import com.my.bookcatalog.model.Book;
import com.my.bookcatalog.repository.BookRepository;
import com.my.bookcatalog.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookServiceImpl service;

    @Test
    void testCreateBook() {
        Book book = new Book();
        book.setTitle("Test");
        when(repository.save(book)).thenReturn(book);
        Book created = service.createBook(book);
        assertEquals("Test", created.getTitle());
    }

    @Test
    void testUpdateBook() {

        Book hisBook =  new BookBuilder()
                .title("title")
                .author("owner")
                .build();

        Book inputBook =  new BookBuilder()
                .title("title1")
                .author("owner")
                .build();
        inputBook.setId(1l);

        when(repository.findById(1l)).thenReturn(Optional.of(hisBook));
        when(repository.save(hisBook)).thenReturn(inputBook);

        Book update1 = service.updateBook(inputBook.getId(),inputBook);
        assertEquals("title1", update1.getTitle());

        hisBook.setTitle("title1");
        Book update2 = service.updateBook(inputBook.getId(),inputBook);
        assertEquals("title1", update2.getTitle());
    }

    @Test
    void testGetAllBooks() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Book(), new Book()));
        assertEquals(2, service.getAllBooks().size());
    }
}

