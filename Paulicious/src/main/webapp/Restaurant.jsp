<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.tap.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FoodExpress - Food Delivery App</title>
<link rel="preconnect" href="https://fo nts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link rel="stylesheet" href="Beauty/Restaurantstyle.css">
</head>
<body>
	


	<!-- Navigation Header -->
	<header class="navbar">
		<div class="nav-container">
			<div class="logo">
				<i class="fas fa-utensils"></i> <a href="home"
					class="home"><span>FoodExpress</span></a>
			</div>
			<nav class="nav-links">
				<a href="#" class="nav-link active">Home</a> <a href="#"
					class="nav-link">Offers</a> <a href="cart" class="nav-link">Cart</a>
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
			<h1>Delicious Food, Delivered Fast</h1>
			<p>Order from your favorite restaurants and get it delivered to
				your doorstep</p>
			<div class="search-bar">
				<i class="fas fa-search"></i> <input type="text"
					placeholder="Search for restaurants or cuisines...">
			</div>
		</div>
	</section>

	<!-- Restaurant Listings -->
	<section class="restaurants">
		<div class="container">
			<h2>Popular Restaurants Near You</h2>
			<div class="restaurant-grid">
<%
	 List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurant");
	for(Restaurant restaurant :restaurants){ %>				
		<!-- Restaurant Card 1 -->
         <div class="restaurant-card">
    <div class="card-image">
        <a href="menu?restaurantId=<%= restaurant.getRestaurantId()%>">
            <img src="<%= restaurant.getImagePath()%>" alt="<%= restaurant.getName() %>"> 

        </a>
        
        <div class="discount-badge">20% OFF</div>
    </div>
    
    <div class="card-content">
        <h3><%= restaurant.getName() %></h3>
        <!-- Show cuisine type instead of address -->
        <p class="cuisine"><%= restaurant.getCuisineType() %></p> 
        <div class="card-info">
            <div class="rating">
                <i class="fas fa-star"></i>
                <span><%= restaurant.getRating()%></span>
            </div>
            <div class="eta"><%= restaurant.getDeliveryTime() %></div>
        </div>
    </div>
</div>

         

	<% }
	%>

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
						<a href="#"><i class="fab fa-facebook"></i></a> <a href="#"><i
							class="fab fa-twitter"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a>
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