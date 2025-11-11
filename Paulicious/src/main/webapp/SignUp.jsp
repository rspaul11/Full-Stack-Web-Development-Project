<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - FoodExpress</title>
    
    <!-- Fonts and Icons -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <!-- Custom Styles -->
    <link rel="stylesheet" href="Beauty/SignUpstyle.css">
</head>
<body>
    <div class="signup-container">
        <div class="signup-header">
            <div class="signup-icon">
                <i class="fas fa-user-plus"></i>
            </div>
            <h1 class="signup-title">Create an Account</h1>
            <p class="signup-subtitle">Join FoodExpress today and enjoy delicious food delivered fast!</p>
        </div>

        <form class="signup-form" action="register" method="POST">
            <div class="form-group">
                <label for="fullName">Full Name</label>
                <div class="input-wrapper">
                    <i class="fas fa-user input-icon"></i>
                    <input type="text" id="fullName" name="fullName" class="form-input" placeholder="Enter your full name" required>
                </div>
            </div>

            <div class="form-group">
                <label for="username">Username</label>
                <div class="input-wrapper">
                    <i class="fas fa-at input-icon"></i>
                    <input type="text" id="username" name="username" class="form-input" placeholder="Choose a username" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-col">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <div class="input-wrapper">
                            <i class="fas fa-lock input-icon"></i>
                            <input type="password" id="password" name="password" class="form-input" placeholder="Create a password" required>
                        </div>
                    </div>
                </div>
                <div class="form-col">
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <div class="input-wrapper">
                            <i class="fas fa-lock input-icon"></i>
                            <input type="password" id="confirmPassword" name="confirmPassword" class="form-input" placeholder="Confirm your password" required>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="email">Email Address</label>
                <div class="input-wrapper">
                    <i class="fas fa-envelope input-icon"></i>
                    <input type="email" id="email" name="email" class="form-input" placeholder="Enter your email address" required>
                </div>
            </div>

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <div class="input-wrapper">
                    <i class="fas fa-phone input-icon"></i>
                    <input type="text" id="phone" name="phone" class="form-input" placeholder="Enter your phone number" required>
                </div>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <div class="input-wrapper">
                    <i class="fas fa-map-marker-alt input-icon"></i>
                    <textarea id="address" name="address" class="form-textarea" placeholder="Enter your complete address" required></textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="role">Role</label>
                <div class="input-wrapper">
                    <i class="fas fa-user-tag input-icon"></i>
                    <select id="role" name="role" class="form-select" required>
                        <option value="role">Select your role</option>
                        <option value="customer">Customer</option>
                        <option value="restaurant-admin">Restaurant Admin</option>
                        <option value="delivery-agent">Delivery Agent</option>
                        <option value="super-admin">Super Admin</option>
                    </select>
                </div>
            </div>

            <button type="submit" class="signup-btn">
                <i class="fas fa-user-plus"></i> Sign Up
            </button>
        </form>

        <div class="login-link">
            Already registered? <a href="login">Login here</a>
        </div>
    </div>
</body>
</html>