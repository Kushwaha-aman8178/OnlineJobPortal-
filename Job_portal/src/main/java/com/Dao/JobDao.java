package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.job;

public class JobDao {

	private Connection con;

	public JobDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addJob(job obj) {
		boolean check = false;

		try {
			String query = "insert into jobTable(id,title,description,category,status,location,postdate) values(jobS.nextval,?,?,?,?,?,sysdate)";
			PreparedStatement ptst = con.prepareStatement(query);

			ptst.setString(1, obj.getTitle());
			ptst.setString(2, obj.getDescription());
			ptst.setString(3, obj.getCategory());
			ptst.setString(4, obj.getStatus());
			ptst.setString(5, obj.getLocation());

			int count = ptst.executeUpdate();

			if (count == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}
	
	
	
	
	public List<job> viewJob(){
		
		List<job> jobs = new ArrayList<job>();
		job obj = null;
		
		try {
		    String query = "select * from jobTable";
			PreparedStatement ptst = con.prepareStatement(query);
			
			ResultSet rst = ptst.executeQuery();
			while(rst.next()) {
				obj = new job();
				
				obj.setId(rst.getInt(1));
				obj.setTitle(rst.getString(2));
				obj.setDescription(rst.getString(3));
				obj.setCategory(rst.getString(4));
				obj.setStatus(rst.getString(5));
				obj.setLocation(rst.getString(6));
				obj.setPostdate(rst.getDate(7)+"");
				
				jobs.add(obj);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return jobs;
		
	}
	
	public List<job> getJobUser(){
		List<job> object = new ArrayList<job>();
		try {
			
			String query = "select * from jobTable where status=?";
			PreparedStatement ptst = con.prepareStatement(query);
			
			ptst.setString(1, "active");
			
			ResultSet rst = ptst.executeQuery();
			
			while(rst.next()) {
				job obj = new job();
				obj.setId(rst.getInt(1));
				obj.setTitle(rst.getString(2));
				obj.setDescription(rst.getString(3));
				obj.setCategory(rst.getString(4));
				obj.setStatus(rst.getString(5));
				obj.setLocation(rst.getString(6));
				obj.setPostdate(rst.getString(7));
				
				object.add(obj);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public List<job> getFilterJob3(String location, String category){
		List<job> object = new ArrayList<job>();
		
		try {
			String query = "select * from jobTable where category=? and location=? and status=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, category);
			ptst.setString(2, location);
			ptst.setString(3, "active");
			
			ResultSet rst = ptst.executeQuery();
			
		    while(rst.next()) {
		    	job obj = new job();
		    	obj.setId(rst.getInt(1));
		    	obj.setTitle(rst.getString(2));
		    	obj.setDescription(rst.getString(3));
		    	obj.setCategory(rst.getString(4));
		    	obj.setStatus(rst.getString(5));
		    	obj.setLocation(rst.getString(6));
		    	obj.setPostdate(rst.getString(7));
		    	
		    	object.add(obj);
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public List<job> getFilterJob2(String location){
		List<job> object = new ArrayList<job>();
		
		try {
			String query = "select * from jobTable where location=? and status=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, location);
			ptst.setString(2,"active");
			
			ResultSet rst = ptst.executeQuery();
			
		    while(rst.next()) {
		    	job obj = new job();
		    	obj.setId(rst.getInt(1));
		    	obj.setTitle(rst.getString(2));
		    	obj.setDescription(rst.getString(3));
		    	obj.setCategory(rst.getString(4));
		    	obj.setStatus(rst.getString(5));
		    	obj.setLocation(rst.getString(6));
		    	obj.setPostdate(rst.getString(7));
		    	
		    	object.add(obj);
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public List<job> getFilterJob1(String category){
		List<job> object = new ArrayList<job>();
		
		try {
			String query = "select * from jobTable where category=? and status=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, category);
			ptst.setString(2, "active");
			
			ResultSet rst = ptst.executeQuery();
			
		    while(rst.next()) {
		    	job obj = new job();
		    	obj.setId(rst.getInt(1));
		    	obj.setTitle(rst.getString(2));
		    	obj.setDescription(rst.getString(3));
		    	obj.setCategory(rst.getString(4));
		    	obj.setStatus(rst.getString(5));
		    	obj.setLocation(rst.getString(6));
		    	obj.setPostdate(rst.getString(7));
		    	
		    	object.add(obj);
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public job editJob1(int id1){
		
		job obj = new job();
		
		try {
			String query = "Select id,title,description,category,status,location,postdate from jobTable where id=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setInt(1, id1);
			ResultSet rst = ptst.executeQuery();
			
			while(rst.next()) {
				obj.setId(rst.getInt(1));
				obj.setTitle(rst.getString(2));
				obj.setDescription(rst.getString(3));
				obj.setCategory(rst.getString(4));
				obj.setStatus(rst.getString(5));
				obj.setLocation(rst.getString(6));
				obj.setPostdate(rst.getString(7)+"");
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public boolean editJobData(job obj) {
		
		try {
			String query = "update jobTable set title=?, description=?, category=?, status=?, location=?, postdate=sysdate where id=?";
			PreparedStatement ptst = con.prepareStatement(query);
			
			ptst.setString(1, obj.getTitle());
			ptst.setString(2, obj.getDescription());
			ptst.setString(3, obj.getCategory());
			ptst.setString(4, obj.getStatus());
			ptst.setString(5, obj.getLocation());
			ptst.setInt(6, obj.getId());
			
			
			int check = ptst.executeUpdate();
			if(check==1) return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteJob(int id) {
		try {
			String query = "delete from jobTable where id=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setInt(1, id);
			
			int check = ptst.executeUpdate();
			
			if(check==1) {
				return true;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
