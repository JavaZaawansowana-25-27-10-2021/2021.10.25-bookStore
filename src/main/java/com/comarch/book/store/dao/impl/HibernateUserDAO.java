package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IUserDAO;
import com.comarch.book.store.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class HibernateUserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM com.comarch.book.store.model.User WHERE login = :login");
        query.setParameter("login", login);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            //???
        }
        session.close();
        return user;
    }
}
