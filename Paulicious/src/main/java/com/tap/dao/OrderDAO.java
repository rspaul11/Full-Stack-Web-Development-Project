package com.tap.dao;

import java.util.List;
import com.tap.model.Order;

public interface OrderDAO {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    int addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Order order);
}