<%@ page import="java.util.*, com.tap.model.*" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - FoodExpress</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="Beauty/CartStyle.css">
</head>
<body>

<!-- Navigation Header -->
<header class="navbar">
    <div class="nav-container">
        <div class="logo">
            <i class="fas fa-utensils"></i>
            <span>FoodExpress</span>
        </div>
        <nav class="nav-links">
            <a href="home" class="nav-link">Home</a>
            <a href="#" class="nav-link">Offers</a>
            <a href="cart" class="nav-link active">Cart</a>
            <a href="orders" class="nav-link">Orders</a>
            <a href="login" class="nav-link">Login</a>
        </nav>
        <div class="mobile-menu">
            <i class="fas fa-bars"></i>
        </div>
    </div>
</header>

<div class="container">
    <div class="main-content">
        <!-- Cart Header -->
        <div class="cart-header">
            <div class="cart-icon"><i class="fas fa-shopping-cart"></i></div>
            <h1 class="cart-title">Your Cart</h1>
        </div>

        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null || cart.isEmpty()) {
        %>
            <h2 style="text-align:center;">Your cart is empty!</h2>
            <h3 style="text-align:center;"><a href="home">Go to Restaurants</a></h3>
        <%
            } else {
                Collection<CartItem> items = cart.getItems();
                double deliveryFee = 49;
                double taxes = 47;
                double subtotal = cart.getTotalPrice();
                double total = subtotal + deliveryFee + taxes;
        %>

        <!-- Cart Items -->
        <div class="cart-items">
            <% for (CartItem item : items) { %>
                <div class="cart-item">
                    <div class="item-image">
                        <img src="images/default.jpg" alt="<%= item.getName() %>">
                    </div>
                    <div class="item-details">
                        <h3 class="item-name"><%= item.getName() %></h3>
                        <p class="item-restaurant">Restaurant ID: <%= item.getRestaurantId() %></p>
                        <span class="item-price">&#8377;<%= item.getPrice() %></span>
                    </div>
                    <div class="item-controls">
                        <!-- Update quantity -->
                        <form action="cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                            <div class="quantity-controls">
                                <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" class="qty-btn minus" <%= item.getQuantity() == 1 ? "disabled" : "" %>>-</button>
                                <span class="qty-number"><%= item.getQuantity() %></span>
                                <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" class="qty-btn plus">+</button>
                            </div>
                        </form>
                        <!-- Delete item -->
                        <form action="cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                            <button type="submit" class="remove-btn" onclick="return confirm('Remove this item?');">
                                <i class="fas fa-trash"></i> Remove
                            </button>
                        </form>
                    </div>
                </div>
            <% } %>
        </div>

        <!-- Cart Summary -->
        <div class="cart-summary">
            <h2 class="summary-title">Order Summary</h2>
            <div class="summary-row">
                <span class="summary-label">Subtotal (<%= items.size() %> items)</span>
                <span class="summary-value">&#8377;<%= subtotal %></span>
            </div>
            <div class="summary-row">
                <span class="summary-label">Delivery Fee</span>
                <span class="summary-value">&#8377;<%= deliveryFee %></span>
            </div>
            <div class="summary-row">
                <span class="summary-label">Taxes & Fees</span>
                <span class="summary-value">&#8377;<%= taxes %></span>
            </div>
            <div class="summary-row">
                <span class="summary-label">Discount</span>
                <span class="summary-value" style="color:#00d4aa;">NO DISCOUNTS</span>
            </div>
            <div class="summary-row total">
                <span class="summary-label">Total Amount</span>
                <span class="summary-value">&#8377;<%= total %></span>
            </div>
        </div>

        <!-- Action Buttons -->
        <div class="cart-actions">
            <a href="checkOut.jsp" class="action-btn checkout-btn"><i class="fas fa-credit-card"></i> Proceed to Checkout</a>
            <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="action-btn add-more-btn"><i class="fas fa-plus"></i> Add More Items</a>
            
            <!-- Clear All Items -->
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="action" value="clear">
                <button type="submit" class="action-btn clear-btn" onclick="return confirm('Clear all items?');">
                    <i class="fas fa-trash-alt"></i> Clear All Items
                </button>
            </form>
        </div>

        <% } %>
    </div>
</div>

</body>
</html>