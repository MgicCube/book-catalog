package com.my.bookcatalog.controller;

import com.my.bookcatalog.builder.BookBuilder;
import com.my.bookcatalog.model.Book;
import com.my.bookcatalog.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService service;

    @InjectMocks
    private BookController controller;

    @Test
    void testCreateBook() {
        Book book =  new BookBuilder()
                .title("create")
                .author("owner")
                .build();
        when(service.createBook(book)).thenReturn(book);
        assertEquals("create", controller.createBook(book).getTitle());
    }

    @Test
    void testUpdateBook() {
        Book book =  new BookBuilder()
                .title("update")
                .author("owner")
                .build();
        when(service.updateBook(1l,book)).thenReturn(book);
        assertEquals("update", controller.updateBook(1l,book).getTitle());
    }

    @Test
    void testGetAllBooks() {
        when(service.getAllBooks()).thenReturn(Arrays.asList(new Book(), new Book()));
        assertEquals(2, controller.getAllBooks().size());
    }

    @Test
    void testGetBook() {
        Book book =  new BookBuilder()
                .title("getBook")
                .author("owner")
                .build();
        when(service.getBookById(1l)).thenReturn(book);
        assertEquals("getBook", controller.getBook(1l).getTitle());
    }

    @Test
    void testDeleteBooks() {
        doNothing().when(service).deleteBook(1l);
        controller.deleteBook(1l);
    }
}
