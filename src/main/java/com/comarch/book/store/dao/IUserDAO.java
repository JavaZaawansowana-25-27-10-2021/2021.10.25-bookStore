package com.comarch.book.store.dao;

import com.comarch.book.store.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
}
