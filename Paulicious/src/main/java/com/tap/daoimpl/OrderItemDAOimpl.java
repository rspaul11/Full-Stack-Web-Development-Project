package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBconnection;

public class OrderItemDAOimpl implements OrderItemDAO {

	private static final String INSERT =
		    "INSERT INTO orderitem (orderid, menuid, quantity, totalamount) VALUES (?, ?, ?, ?)";


    private static final String UPDATE = "UPDATE orderitem SET orderid=?, menuid=?, quantity=?, totalamount=? WHERE orderitemid=?";

    private static final String SELECT = "SELECT * FROM orderitem WHERE orderitemid=?";
    private static final String SELECT_ALL = "SELECT * FROM orderitem";

    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> list = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                OrderItem item = new OrderItem();
                item.setOrderItemId(rs.getInt("orderitemid"));
                item.setOrderId(rs.getInt("orderid"));
                item.setMenuId(rs.getInt("menuid"));
                item.setQuantity(rs.getInt("quantity"));
                item.setTotalAmount(rs.getDouble("totalamount"));
                list.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public OrderItem getOrderItem(int id) {
        OrderItem item = null;

        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                item = new OrderItem();
                item.setOrderItemId(rs.getInt("orderitemid"));
                item.setOrderId(rs.getInt("orderid"));
                item.setMenuId(rs.getInt("menuid"));
                item.setQuantity(rs.getInt("quantity"));
                item.setTotalAmount(rs.getDouble("totalamount"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public void addOrderItem(OrderItem item) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {

           
            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getTotalAmount());

            ps.executeUpdate();
            
            
            System.out.println("Order item inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderItem(OrderItem item) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {

            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getMenuId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getTotalAmount());
            ps.setInt(5, item.getOrderItemId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int rderId = rs.getInt(1); // this must be passed to addOrderItem
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(OrderItem item) {
        // Optional: implement if needed
    }
}