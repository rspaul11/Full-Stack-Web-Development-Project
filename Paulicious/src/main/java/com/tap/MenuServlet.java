package com.tap;

import java.io.IOException;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.daoimpl.MenuDAOimpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/menu")
public class MenuServlet  extends HttpServlet{



	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restId= Integer.parseInt(req.getParameter("restaurantId"));
		HttpSession session = req.getSession();
		
		session.setAttribute("restaurantId", restId);
		

		MenuDAO daoImpl = new MenuDAOimpl();
		List<Menu> menusByRestaurant = daoImpl.getMenusByRestaurant(restId);
		for (Menu menu : menusByRestaurant) {
			System.out.println(menu);
		}
		req.setAttribute("menusByRestaurant", menusByRestaurant);
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req,resp);
		
		
	
	}
	}