package com.comarch.book.store.dao;

import com.comarch.book.store.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface IOrderJPADOA extends CrudRepository<Order, Integer> {
    Order findById(int id);

    Order findByDate(Date date);
}
