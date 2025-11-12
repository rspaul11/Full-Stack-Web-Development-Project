<%@ page import="java.util.*, com.tap.model.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Checkout - FoodExpress</title>
    <!-- External Stylesheets -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="Beauty/checkout.css">
</head>
<body>

<!-- Navigation Header -->
<header class="navbar">
    <div class="nav-container">
        <div class="logo">
            <i class="fas fa-utensils"></i>
            <a href="home" class="home"><span>FoodExpress</span></a>
        </div>
        <nav class="nav-links">
            <a href="home" class="nav-link active">Home</a>
            <a href="#" class="nav-link">Offers</a>
            <a href="cart.jsp" class="nav-link">Cart</a>
            <a href="orders" class="nav-link">Orders</a>
            <a href="login" class="nav-link">Login</a>
        </nav>
        <div class="mobile-menu">
            <i class="fas fa-bars"></i>
        </div>
    </div>
</header>

<!-- Hero Section -->
<section class="hero">
    <div class="hero-content">
        <h1>Finalize Your Order</h1>
        <p>Review your items and enter your delivery information</p>
    </div>
</section>

<!-- Checkout Section -->
<section class="restaurants">
    <div class="container">
        <h2>Checkout</h2>
        <div class="checkout-grid">

            <!-- Cart Summary -->
            <div class="cart-summary">
                <h3>Your Order</h3>
                <%
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart == null || cart.getItems().isEmpty()) {
                %>
                    <p>Your cart is empty. <a href="home">Go to Home</a></p>
                <%
                    } else {
                        for (CartItem item : cart.getItems()) {
                %>
                    <div class="cart-item">
                        <p><strong><%= item.getName() %></strong> x <%= item.getQuantity() %></p>
                        <p><strong>&#8377;<%= item.getPrice() * item.getQuantity() %></strong></p>
                    </div>
                <%
                        } // end for
                %>
                    <div class="cart-item">
                        <p><strong>Delivery Fee</strong></p>
                        <p>&#8377; 49</p>
                    </div>
                    <div class="cart-item">
                        <p><strong>Taxes & Fees</strong></p>
                        <p>&#8377; 47</p>
                    </div>
                    <hr>
                    <div class="total-amount">
                        <p><strong>Total:</strong></p>
                        <%
                            double total = cart.getTotalPrice() + 49 + 47;
                        %>
                        <p><strong>&#8377;<%= total %></strong></p>
                    </div>
                <%
                    } // end else
                %>
            </div>

            <!-- Delivery Details Form -->
            <div class="delivery-form">
                <h3>Delivery Details</h3>
                <form action="checkout" method="post">
                    <input type="text" name="fullName" placeholder="Full Name" required>
                    <input type="text" name="address" placeholder="Full Address" required>
                    <input type="text" name="phone" placeholder="Phone Number" required>
                    <select name="paymentMode" required>
                        <option value="">Select Payment Method</option>
                        <option value="COD">Cash on Delivery</option>
                        <option value="UPI">UPI</option>
                        <option value="Card">Credit/Debit Card</option>
                    </select>
                    <button type="submit" class="place-order-btn">Place Order</button>
                </form>
            </div>

        </div>
    </div>
</section>

<!-- Footer -->
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