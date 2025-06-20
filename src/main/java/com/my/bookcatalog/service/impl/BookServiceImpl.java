package com.my.bookcatalog.service.impl;

import com.my.bookcatalog.model.Book;
import com.my.bookcatalog.observer.BookChangeNotifier;
import com.my.bookcatalog.observer.BookTitleChangeLogger;
import com.my.bookcatalog.repository.BookRepository;
import com.my.bookcatalog.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 图书服务层实现类
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final BookChangeNotifier notifier;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
        this.notifier = new BookChangeNotifier();
        this.notifier.registerObserver(new BookTitleChangeLogger());
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);

        boolean titleChanged = !Objects.equals(existing.getTitle(), book.getTitle());
        Book oldCopy = new Book(); // 深拷贝旧数据
        BeanUtils.copyProperties(existing, oldCopy);

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setGenre(book.getGenre());
        existing.setYearPublished(book.getYearPublished());
        Book updated = repository.save(existing);
        if (titleChanged) {
            notifier.notifyTitleChange(oldCopy, updated);
        }
        return updated;
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
