package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.util.DBconnection;

public class OrderDAOimpl implements OrderDAO {

    // Added address column to INSERT
    private String INSERT = "INSERT INTO `orders` (restaurantid, userid, orderdate, totalamount, status, paymentmode, address) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    // Added address column to UPDATE
    private String UPDATE = "UPDATE `orders` SET restaurantid=?, userid=?, orderdate=?, totalamount=?, status=?, paymentmode=?, address=? WHERE orderid=?";

    private String SELECT = "SELECT * FROM `orders` WHERE orderid=?";
    private String SELECT_ALL = "SELECT * FROM `orders`";

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt("orderid"));
                o.setRestaurantId(rs.getInt("restaurantid"));
                o.setUserId(rs.getInt("userid"));
                o.setOrderDate(rs.getTimestamp("orderdate"));
                o.setTotalAmount(rs.getDouble("totalamount"));
                o.setStatus(rs.getString("status"));
                o.setPaymentMode(rs.getString("paymentmode"));
                o.setAddress(rs.getString("address")); // ✅ Corrected
                orders.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT)) {

            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getInt("orderid"));
                order.setRestaurantId(rs.getInt("restaurantid"));
                order.setUserId(rs.getInt("userid"));
                order.setOrderDate(rs.getTimestamp("orderdate"));
                order.setTotalAmount(rs.getDouble("totalamount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentMode(rs.getString("paymentmode"));
                order.setAddress(rs.getString("address"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int addOrder(Order order) {
        int orderId = 0;	
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS))
        {

            ps.setInt(1, order.getRestaurantId());
            ps.setInt(2, order.getUserId());
            ps.setTimestamp(3, order.getOrderDate());
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentMode());
            ps.setString(7, order.getAddress()); // ✅ Added address

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            System.out.println("Order inserted successfully with ID: " + orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public void updateOrder(Order order) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {

            ps.setInt(1, order.getRestaurantId());
            ps.setInt(2, order.getUserId());
            ps.setTimestamp(3, order.getOrderDate());
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentMode());
            ps.setString(7, order.getAddress()); // ✅ Added address
            ps.setInt(8, order.getOrderId());

            ps.executeUpdate();
            System.out.println("Order updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(Order order) {
        // Not implemented
    }
}