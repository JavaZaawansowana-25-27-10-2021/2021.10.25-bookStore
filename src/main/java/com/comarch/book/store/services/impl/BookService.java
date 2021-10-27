package com.comarch.book.store.services.impl;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookDAO bookDAO;

    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBooks();
    }
}
