package com.comarch.book.store.dao.impl;

import com.comarch.book.store.dao.IOrderDAO;
import com.comarch.book.store.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO implements IOrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch(Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
