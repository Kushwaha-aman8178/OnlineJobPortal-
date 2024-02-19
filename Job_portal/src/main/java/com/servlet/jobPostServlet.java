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

@WebServlet("/addJob")
public class jobPostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
			
			JobDao obj = new JobDao(DBConnect.getConnection());
			
			job jobObj = new job();
			jobObj.setTitle(title);
			jobObj.setDescription(desc);
			jobObj.setCategory(category);
			jobObj.setStatus(status);
			jobObj.setLocation(location);
			
			boolean check = obj.addJob(jobObj);
			
			HttpSession session = req.getSession();
			
			if(check) {
				session.setAttribute("msg", "Job posted Successfully");
				resp.sendRedirect("addJob.jsp");
			}
			else {
				session.setAttribute("msg", "Something went wrong");
				resp.sendRedirect("addJob.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
