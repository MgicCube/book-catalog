package com.my.bookcatalog.strategy;

import com.my.bookcatalog.model.Book;

import java.util.List;

public class BookSorter {
    private SortStrategy strategy;

    public BookSorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> sortBooks(List<Book> books) {
        return strategy.sort(books);
    }
}

