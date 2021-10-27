package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCBookDAO implements IBookDAO {

    @Autowired
    Connection connection;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM tbook";

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return books;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        String sql = "SELECT * FROM tbook WHERE isbn = ?";

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Book book = new Book();
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setIsbn(rs.getString("isbn"));
            book.setPrice(rs.getDouble("price"));
            return book;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void persistBook(Book book) {
        throw new NotImplementedException();
    }
}
