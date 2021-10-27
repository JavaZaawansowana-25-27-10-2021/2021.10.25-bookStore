package com.comarch.book.store.services.impl;

import com.comarch.book.store.dao.IUserDAO;
import com.comarch.book.store.model.User;
import com.comarch.book.store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Transactional(readOnly = true)
    public void authenticate(String login, String password) {
        User user = userDAO.getUserByLogin(login);
        if(user != null && user.getPassword().equals(password)) {
            this.sessionObject.setUser(user);
        }

        step();
    }

    private void step() {

    }
}
