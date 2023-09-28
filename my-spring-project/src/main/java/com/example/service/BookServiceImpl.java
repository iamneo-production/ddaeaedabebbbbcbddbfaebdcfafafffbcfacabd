package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BookDao;
import com.example.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
}