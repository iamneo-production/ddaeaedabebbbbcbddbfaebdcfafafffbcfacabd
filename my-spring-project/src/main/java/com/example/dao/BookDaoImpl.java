package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }
}