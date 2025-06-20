package com.my.bookcatalog.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 书名
     */
    private String title;
    /**
     * 作者
     */
    private String author;

    /**
     * 类别
     */
    private String genre;
    /**
     * 发布年份
     */
    private int yearPublished;
}

