package com.my.bookcatalog.strategy;

import com.my.bookcatalog.model.Book;

import java.util.List;

public interface SortStrategy {

    /**
     * 图书集合排序
     * @param books 图书集合
     * @return 有序集合
     */
    List<Book> sort(List<Book> books);
}
