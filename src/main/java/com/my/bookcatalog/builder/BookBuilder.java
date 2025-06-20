package com.my.bookcatalog.builder;
import com.my.bookcatalog.model.Book;

public class BookBuilder {

    private final Book book = new Book();

    public BookBuilder title(String title) {
        book.setTitle(title);
        return this;
    }

    public BookBuilder author(String author) {
        book.setAuthor(author);
        return this;
    }

    public BookBuilder genre(String genre) {
        book.setGenre(genre);
        return this;
    }

    public BookBuilder yearPublished(int year) {
        book.setYearPublished(year);
        return this;
    }

    public Book build() {
        return book;
    }
}

