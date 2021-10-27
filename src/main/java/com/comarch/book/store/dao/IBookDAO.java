package com.comarch.book.store.dao;

import com.comarch.book.store.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getAllBooks();
    Book getBookByISBN(String isbn);
    public void persistBook(Book book);
}
