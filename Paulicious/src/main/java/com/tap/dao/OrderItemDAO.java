package com.tap.dao;

import java.util.List;
import com.tap.model.OrderItem;

public interface OrderItemDAO {
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItem(int id);
    void addOrderItem(OrderItem item);
    void updateOrderItem(OrderItem item);
    void deleteOrderItem(OrderItem item);
}