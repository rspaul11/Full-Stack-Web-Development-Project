package com.tap;

import java.io.IOException;

import com.tap.daoimpl.MenuDAOimpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Get or initialize cart
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Get action safely
        String action = req.getParameter("action");

        if (action != null) {
            if ("add".equalsIgnoreCase(action)) {
                addItemToCart(req, cart);
            } else if ("update".equalsIgnoreCase(action)) {
                updateItemInCart(req, cart);
            } else if ("delete".equalsIgnoreCase(action)) {
                deleteItemFromCart(req, cart);
            } else if ("clear".equalsIgnoreCase(action)) {
                cart.clearCart();
            } else {
                System.out.println("Unknown action: " + action);
            }
        } else {
            System.out.println("No action parameter provided.");
        }


        resp.sendRedirect("cart.jsp");
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            MenuDAOimpl dao = new MenuDAOimpl();
            Menu menu = dao.getMenu(menuId);

            if (menu != null) {
                CartItem item = new CartItem(
                        menuId,
                        menu.getMenuId(),
                        menu.getRestaurantId(),
                        menu.getItemName(),
                        quantity,
                        menu.getPrice()
                );
                cart.addItemToCart(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateItemInCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            if (quantity <= 0) {
                cart.deleteItemFromCart(menuId);
            } else {
                cart.updateItemInCart(menuId, quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            cart.deleteItemFromCart(menuId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}