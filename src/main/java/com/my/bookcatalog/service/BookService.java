package com.my.bookcatalog.service;

import com.my.bookcatalog.model.Book;

import java.util.List;

/**
 * 图书服务层
 */
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}

