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
import com.entity.job;

@WebServlet("/editJob")
public class editJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
			
			JobDao object = new JobDao(DBConnect.getConnection());
			job object1 = new job();
			
			object1.setId(id);
			object1.setTitle(title);
			object1.setLocation(location);
			object1.setCategory(category);
			object1.setStatus(status);
			object1.setDescription(desc);
			
			boolean check = object.editJobData(object1);
			HttpSession session = req.getSession();
			
			if(check==true) {
				session.setAttribute("msg", "Data updated successfully");
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
