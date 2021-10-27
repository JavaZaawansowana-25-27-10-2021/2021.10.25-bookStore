package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IUserDAO;
import com.comarch.book.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUserDAO implements IUserDAO {

    @Autowired
    Connection connection;

    @Override
    public User getUserByLogin(String login) {
        String sql = "SELECT * FROM tuser WHERE login = ?";

        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User();
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
