<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List,com.tap.model.Menu,com.tap.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Spice Palace Menu - FoodExpress</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link rel="stylesheet" href="Beauty/MenuStyel.css">
</head>
<body>
	<!-- Navigation Header -->
	<header class="navbar">
		<div class="nav-container">
			<div class="logo">
				<i class="fas fa-utensils"></i> <span>FoodExpress</span>
			</div>
			<nav class="nav-links">
				<a href="home" class="nav-link">Home</a> <a href="#"
					class="nav-link">Offers</a> <a href="cart" class="nav-link">Cart</a>
					<a href="orders" class="nav-link">Orders</a>
				<a href="login" class="nav-link">Login</a>
			</nav>
			<a href="home" class="back-btn"> <i
				class="fas fa-arrow-left"></i> Back to Home
			</a>
		</div>
	</header>

	<!-- Banner Section -->
	<!-- <section class="banner">
	
		<div class="banner-content">
			<h1></h1>
			<p class="subtitle"> 		  </p>
			<div class="restaurant-info">
				<div class="restaurant-rating">
					<i class="fas fa-star"></i> <span>  		   </span>
				</div>
				<div class="delivery-time">
					<i class="fas fa-clock"></i> <span>  			</span>
				</div>
			</div>
		</div>
	</section>  -->
	

		 <section class="menu-section">
			<div class="container">
				<h2></h2>
				<div class="menu-grid">

					<% List<Menu>menus =(List<Menu>)request.getAttribute("menusByRestaurant");
	 for( Menu menu :menus){%>
	 <!-- Menu Item 1 -->
					<div class="menu-item">
						<div class="menu-image">
							<img
								src="<%=menu.getImagePath()%>"
								alt="Chicken Biryani">
							<div class="category-badge"><%= menu.getItemName() %></div>
						</div>
						<div class="menu-content">
							<h4><%= menu.getItemName() %></h4>
							<p class="description"><%=menu.getDescription() %></p>
							<div class="menu-footer">
								<span class="price"><%=menu.getPrice()%></span>
								<div class="rating">
									<i class="fas fa-star"></i> <span><%=menu.getRatings() %></span>
								</div>
							</div>
							
							<form action="cart">
							<input type="hidden" value="<%= menu.getMenuId()%>" name="menuId">
							<input type="hidden" value="1" name="quantity">
							<input type="hidden" value="<%= menu.getRestaurantId()%>" name="restId">
							<input type="hidden" value="add" name="action">
							<input type="submit" value="🛒 Add to Cart" class="add-to-cart">
						</form>
						</div>
					</div>
					<%}%>


				</div>
			</div>
		</section>
	
	<!-- Menu Section -->
	
</body>
</html>