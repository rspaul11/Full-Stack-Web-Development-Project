package com.tap;

import com.tap.dao.OrderDAO;
import com.tap.daoimpl.OrderDAOimpl;
import com.tap.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO = new OrderDAOimpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
            req.setAttribute("orders", orderDAO.getOrderById(userId));
            req.getRequestDispatcher("Orders.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}