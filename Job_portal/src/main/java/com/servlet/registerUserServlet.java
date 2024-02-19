package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.db.DBConnect;
import com.entity.user;

@WebServlet("/register")
public class registerUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name = req.getParameter("name");
			String qual= req.getParameter("qual");
			String email= req.getParameter("email");
			String password = req.getParameter("password");
			
			UserDao obj = new UserDao(DBConnect.getConnection());
			user object = new user(name,email,password,qual,"user");
			
			boolean check = obj.addUser(object);
			HttpSession session = req.getSession();
			
			if(check==true) {
				session.setAttribute("msg", "User Registered Successfully");
				resp.sendRedirect("register.jsp");
			}
			else {
				session.setAttribute("msg", "Something went Wrong");
				resp.sendRedirect("register.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
