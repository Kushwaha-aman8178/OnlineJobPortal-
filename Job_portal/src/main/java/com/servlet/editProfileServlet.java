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

@WebServlet("/editProfile")
public class editProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String qual = req.getParameter("qual");
			String email = req.getParameter("email");
			String pass = req.getParameter("password");

			UserDao obj = new UserDao(DBConnect.getConnection());

			boolean check = obj.editProfile(id, name, email, pass, qual);
			HttpSession session = req.getSession();

			if (check == true) {
				session.setAttribute("msg", "Profile Updated successfully");
				resp.sendRedirect("home.jsp");
			} else {
				session.setAttribute("msg", "Something went wrong");
				resp.sendRedirect("home.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
