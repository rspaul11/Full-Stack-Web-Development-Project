package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDaoImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class SignupServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("fullName");
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        String cnfpass = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String pno = req.getParameter("phone");
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Validate passwords
        if (pass == null || cnfpass == null || !pass.equals(cnfpass)) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Passwords do not match');");
            out.println("location='SignUp.jsp';");
            out.println("</script>");
            return;
        }

        // Validate role (ensure not left at default value)
        if (role == null || role.equals("") || role.equals("role")) {
            out.println("<script type='text/javascript'>");
            out.println("alert('Please select a valid role');");
            out.println("location='SignUp.jsp';");
            out.println("</script>");
            return;
        }

        User user = new User(0, name, uname, pass, email, pno, address, role, null, null);
        UserDAO dao = new UserDaoImpl();
        dao.addUser(user);

        // Redirect to login page after successful registration
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}