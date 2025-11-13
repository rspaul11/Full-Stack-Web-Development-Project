<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Order Confirmation - FoodExpress</title>

  <!-- Fonts and Icons -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />

  <!-- CSS -->
  <link rel="stylesheet" href="Beauty/orderConfirm.css"/>
</head>
<body>

  <!-- Header -->
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
  
   
       

  <!-- Confirmation Section -->
  
  <section class="confirmation-section">

    <div class="confirmation-card">
      <i class="fas fa-check-circle check-icon"></i>
      <h1>Order Placed Successfully!</h1>
      <p>Thank you for ordering with <strong>FoodExpress</strong>.<br>Your delicious food is being prepared 🚀</p>
      <a href="home" class="back-home">Back to Home</a>
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

  <!-- Confetti Script -->
  <script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.5.1/dist/confetti.browser.min.js"></script>
  <script>
    // Fire confetti once when page loads
    window.addEventListener('load', () => {
      confetti({
        particleCount: 150,
        spread: 70,
        origin: { y: 0.6 }
      });
    });
  </script>

</body>
</html>