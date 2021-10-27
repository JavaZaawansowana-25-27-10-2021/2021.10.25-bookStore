package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IUserDAO;
import com.comarch.book.store.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    List<User> users = new ArrayList<>();

    public UserDAO() {
        this.users.add(new User("admin", "admin"));
        this.users.add(new User("user", "user"));
    }

    public User getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }
}
