package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.JobDao;
import com.db.DBConnect;

@WebServlet("/deleteServlet")
public class deleteJobServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			JobDao object = new JobDao(DBConnect.getConnection());
			
			boolean check = object.deleteJob(id);
			HttpSession session = req.getSession();
			
			if(check==true) {
				session.setAttribute("msg", "Data deleted successfully");
				resp.sendRedirect("viewJob.jsp");
			}
			else {
				session.setAttribute("msg", "Something went wrong");
				resp.sendRedirect("viewJob.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
