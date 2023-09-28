package com.example.dao;

import java.util.List;

import com.example.model.Book;

public interface BookDao {
    List<Book> getAllBooks();

    void addBook(Book book);
}
