package com.comarch.book.store.dao;

import com.comarch.book.store.model.Order;

public interface IOrderDAO {
    void saveOrder(Order order);
}
