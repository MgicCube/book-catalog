package com.my.bookcatalog.strategy;

import com.my.bookcatalog.model.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByYear implements SortStrategy {
    public List<Book> sort(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getYearPublished)).collect(Collectors.toList());
    }
}
