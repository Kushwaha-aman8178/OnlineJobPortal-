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

@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			user userObj = new user();
			HttpSession session = req.getSession();
			
			if("admin@gmail.com".equals(email) && "admin@123".equals(pass)) {
				
				session.setAttribute("userObj", userObj);
				userObj.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}
			else {
				
				UserDao obj = new UserDao(DBConnect.getConnection());
				user object = obj.userLogin(email,pass);
				
				if(object!=null) {
					session.setAttribute("userObj", object);
					resp.sendRedirect("home.jsp");
				}
				else {
					session.setAttribute("msg", "Invalid user name or password");
					resp.sendRedirect("login.jsp");
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
