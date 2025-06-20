package com.my.bookcatalog.strategy;

import com.my.bookcatalog.builder.BookBuilder;
import com.my.bookcatalog.model.Book;
import com.my.bookcatalog.strategy.BookSorter;
import com.my.bookcatalog.strategy.SortByTitle;
import com.my.bookcatalog.strategy.SortByYear;
import com.my.bookcatalog.strategy.SortStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStrategyTest {

    @Test
    void testStrategy() {

        Book b1 = new BookBuilder().title("456").yearPublished(2025).build();
        Book b2 = new BookBuilder().title("123").yearPublished(2026).build();
        List<Book> books = Arrays.asList(b1, b2);

        SortStrategy titleSort = new SortByTitle();
        BookSorter sorter = new BookSorter(titleSort);
        List<Book> sortedByTitle = sorter.sortBooks(books);

        assertEquals("123",sortedByTitle.get(0).getTitle());

        sorter.setStrategy(new SortByYear());
        List<Book> sortedByYear = sorter.sortBooks(books);

        assertEquals(2025,sortedByYear.get(0).getYearPublished());
    }
}
