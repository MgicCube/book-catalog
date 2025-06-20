package com.my.bookcatalog.builder;

import com.my.bookcatalog.builder.BookBuilder;
import com.my.bookcatalog.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookBuilderTest {
    @Test
    void testBuilder() {
        Book book = new BookBuilder()
                .author("xxx")
                .title("test1")
                .yearPublished(2025)
                .genre("小说")
                .build();
        assertEquals("test1",book.getTitle());
    }
}
