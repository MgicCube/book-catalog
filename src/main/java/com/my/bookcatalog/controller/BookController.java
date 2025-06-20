package com.my.bookcatalog.controller;

import com.my.bookcatalog.model.Book;
import com.my.bookcatalog.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书控制层
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 获取图书集合
     * @return
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * 获取图书详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    /**
     * 创建图书
     * @param book
     * @return
     */
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    /**
     * 更新图书
     * @param id
     * @param book
     * @return
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    /**
     * 删除图书
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

