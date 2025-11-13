<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In - FoodExpress</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="Beauty/LoginStyle.css">
</head>
<body>
    <div class="signin-container">
        <div class="signin-header">
            <div class="signin-icon">
                <i class="fas fa-sign-in-alt"></i>
            </div>
            <h1 class="signin-title">Sign In</h1>
            <p class="signin-subtitle">Welcome back! Please sign in to your account</p>
        </div>

        <!-- Display error if login fails -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <div style="color: red; text-align: center; margin-bottom: 10px;"><%= error %></div>
        <%
            }
        %>

        <form class="signin-form" action="login" method="POST">
            <div class="form-group">
                <label for="email">Email</label>
                <div class="input-wrapper">
                    <i class="fas fa-user input-icon"></i>
                    <input type="email" id="email" name="email" class="form-input" placeholder="Enter your email" required>
                </div>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <div class="input-wrapper">
                    <i class="fas fa-lock input-icon"></i>
                    <input type="password" id="password" name="password" class="form-input" placeholder="Enter your password" required>
                </div>
                <div class="forgot-password">
                    <a href="#" onclick="alert('Forgot password feature not implemented yet')">Forgot Password?</a>
                </div>
            </div>

            <div class="remember-me">
                <input type="checkbox" id="rememberMe" name="rememberMe">
                <label for="rememberMe">Remember me</label>
            </div>

            <button type="submit" class="signin-btn">
                <i class="fas fa-sign-in-alt"></i> Sign In
            </button>
        </form>

        <div class="divider">
            <span>or continue with</span>
        </div>

        <div class="social-login">
            <a href="#" class="social-btn google" onclick="alert('Google login not implemented yet')">
                <i class="fab fa-google"></i>
                Google
            </a>
            <a href="#" class="social-btn facebook" onclick="alert('Facebook login not implemented yet')">
                <i class="fab fa-facebook-f"></i>
                Facebook
            </a>
        </div>

        <div class="signup-link">
            Don't have an account? <a href="register">Register here</a>
        </div>
    </div>
</body>
</html>