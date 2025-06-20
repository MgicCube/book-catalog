package com.my.bookcatalog.observer;

import com.my.bookcatalog.model.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookTitleChangeLogger implements BookObserver {

    @Override
    public void onTitleChanged(Book oldBook, Book newBook) {
        log.info("书名已修改：从{}变为{}", oldBook.getTitle(), newBook.getTitle());
    }
}
