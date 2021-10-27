package com.comarch.book.store.services.impl;

import com.comarch.book.store.dao.IOrderDAO;
import com.comarch.book.store.dao.IOrderJPADOA;
import com.comarch.book.store.model.Order;
import com.comarch.book.store.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    IOrderJPADOA orderJPADOA;

    @Override
    public void saveOrder(Order order) {
        this.orderDAO.saveOrder(order);
    }

    public void saveOrder2(Order order) {
        this.orderJPADOA.findByDate(new Date());
    }
}
