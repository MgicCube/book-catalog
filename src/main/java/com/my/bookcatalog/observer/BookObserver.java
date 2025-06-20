package com.my.bookcatalog.observer;

import com.my.bookcatalog.model.Book;

public interface BookObserver {
    void onTitleChanged(Book oldBook, Book newBook);
}
