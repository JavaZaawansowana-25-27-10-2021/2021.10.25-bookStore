package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JPABookDAO implements IBookDAO {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public void persistBook(Book book) {
        Session session = this.sessionFactory.openSession();
        session.save(book);
        session.close();
    }
}
