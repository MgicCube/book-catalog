package com.my.bookcatalog.observer;

import com.my.bookcatalog.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookChangeNotifier {
    private final List<BookObserver> observers = new ArrayList<>();

    public void registerObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void notifyTitleChange(Book oldBook, Book newBook) {
        for (BookObserver observer : observers) {
            observer.onTitleChanged(oldBook, newBook);
        }
    }
}

