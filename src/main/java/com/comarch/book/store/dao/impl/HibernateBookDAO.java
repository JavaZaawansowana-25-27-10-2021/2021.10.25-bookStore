package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookDAO implements IBookDAO {

    @Autowired
    SessionFactory sessionFactory;

    private final static String BOOK_CLASS = "com.comarch.book.store.model.Book";

    @Override
    public List<Book> getAllBooks() {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery("FROM " + BOOK_CLASS);
        List<Book> books = query.getResultList();
        session.close();
        return books;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery("FROM " + BOOK_CLASS +" WHERE isbn = :isbn");
        query.setParameter("isbn", isbn);
        Book book = query.getSingleResult();
        session.close();
        return book;
    }

    public void persistBook(Book book) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(book);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void updateBook(Book book) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(book);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
