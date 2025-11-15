package com.tap;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.dao.OrderItemDAO;
import com.tap.daoimpl.OrderDAOimpl;
import com.tap.daoimpl.OrderItemDAOimpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAOimpl();
        orderItemDAO = new OrderItemDAOimpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Object userObj = session.getAttribute("userId");
        Object restObj = session.getAttribute("restaurantId");

        if (cart != null && userObj != null && restObj != null && !cart.getItems().isEmpty()) {
            int userId = (int) userObj;
            int restaurantId = (int) restObj;

            String paymentMode = req.getParameter("paymentMode");
            String address = req.getParameter("address");
            session.setAttribute("address", address);
            String status = "Pending";

            // Fees
            double deliveryFee = 49;
            double taxes = 47;
            double subtotal = cart.getTotalPrice();
            double totalAmount = subtotal + deliveryFee + taxes;

            // Create Order
            Order order = new Order();
            order.setRestaurantId(restaurantId);
            order.setUserId(userId);
            order.setOrderDate(new Timestamp(System.currentTimeMillis()));
            order.setTotalAmount(totalAmount);
            order.setStatus(status);
            order.setPaymentMode(paymentMode);
            order.setAddress(address);
            int orderId = orderDAO.addOrder(order);

            // Save order items
            List<OrderItem> orderItemsList = new ArrayList<>();
            for (CartItem item : cart.getItems()) {
                int menuId = item.getMenuId();
                int quantity = item.getQuantity();
                double totalPrice = item.getPrice() * quantity;

                OrderItem orderItem = new OrderItem(orderId, userId, menuId, quantity, totalPrice);
                orderItemDAO.addOrderItem(orderItem);
                orderItemsList.add(orderItem);
            }

            session.setAttribute("orderItems", orderItemsList);
            session.setAttribute("orderId", orderId);
            session.removeAttribute("cart");

            resp.sendRedirect("orderConfirm.jsp");
        } else {
            resp.sendRedirect("cart.jsp");
        }
    }
}