<%@ page import="java.util.List" %>
<%@ page import="com.tap.daoimpl.OrderDAOimpl" %>
<%@ page import="com.tap.model.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    OrderDAOimpl orderDAO = new OrderDAOimpl();
    List<Order> orders = orderDAO.getAllOrders();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Orders - FoodExpress</title>
<link rel="stylesheet" href="Beauty/orders.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

<header class="navbar">
    <div class="nav-container">
        <div class="logo">
            <i class="fas fa-utensils"></i> <a href="home.jsp"><span>FoodExpress</span></a>
        </div>
        <nav class="nav-links">
            <a href="home" class="nav-link">Home</a>
            <a href="#" class="nav-link">Offers</a>
            <a href="cart" class="nav-link">Cart</a>
            <a href="orders" class="nav-link active">Orders</a>
            <a href="login" class="nav-link">Login</a>
        </nav>
    </div>
</header>

<section class="orders">
    <div class="container">
        <h2>My Orders</h2>
        <div class="order-grid">
            <%
                if (orders != null && !orders.isEmpty()) {
                    for (Order o : orders) {
            %>
                <div class="order-card">
                    <div class="order-header">
                        <h3>Order #<%= o.getOrderId() %></h3>
                        <span class="order-status <%= o.getStatus().toLowerCase() %>"><%= o.getStatus() %></span>
                    </div>
                    <p><strong>Restaurant ID:</strong> <%= o.getRestaurantId() %></p>
                    <p><strong>Date:</strong> <%= o.getOrderDate() %></p>
                    <hr>
                    <p><strong>Total:</strong> ₹<%= o.getTotalAmount() %></p>
                    <p><strong>Payment Mode:</strong> <%= o.getPaymentMode() %></p>
                </div>
            <%
                    }
                } else {
            %>
                <p>No orders found.</p>
            <%
                }
            %>
        </div>
    </div>
</section>

<footer class="footer">
    <div class="container">
        <div class="footer-content">
            <div class="footer-section">
                <h4>FoodExpress</h4>
                <p>Your favorite food, delivered fast and fresh.</p>
            </div>
            <div class="footer-section">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h4>Follow Us</h4>
                <div class="social-links">
                    <a href="#"><i class="fab fa-facebook"></i></a> 
                    <a href="#"><i class="fab fa-twitter"></i></a> 
                    <a href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2025 FoodExpress. All rights reserved.</p>
        </div>
    </div>
</footer>

</body>
</html>