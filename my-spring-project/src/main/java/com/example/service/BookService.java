package com.example.service;

import java.util.List;

import com.example.model.Book;

public interface BookService {
    List<Book> getAllBooks();

    void addBook(Book book);
}