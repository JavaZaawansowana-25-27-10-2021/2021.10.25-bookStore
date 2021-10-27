package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.model.Book;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import java.util.ArrayList;

public class BookDAO implements IBookDAO {
    private List<Book> bookList = new ArrayList<>();

    public BookDAO() {
        this.bookList.add(new Book("K1", "Sienkiewicz", 100.0, "3456-546-45-456-45"));
        this.bookList.add(new Book("K2", "A2", 110.0, "456-66-443564-343-33-23"));
        this.bookList.add(new Book("K3", "A3", 30.0, "567-5678-5678-567"));
    }

    public List<Book> getAllBooks() {
        return this.bookList;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        //TODO
        return null;
    }

    @Override
    public void persistBook(Book book) {
        throw new NotImplementedException();
    }
}
