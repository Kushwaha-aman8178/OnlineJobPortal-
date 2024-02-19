package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	public boolean addUser(user obj) {
		boolean check = false;
		
		try {
			String query = "insert into userTable(id,name,email,password,qual,role) values(userS.nextVal,?,?,?,?,?)";
			PreparedStatement ptst = con.prepareStatement(query);
			
			ptst.setString(1, obj.getName());
			ptst.setString(2, obj.getEmail());
			ptst.setString(3, obj.getPassword());
			ptst.setString(4, obj.getQual());
			ptst.setString(5, obj.getRole());
			
			
			int count = ptst.executeUpdate();
			if(count==1) {
				check = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public user userLogin(String email, String pass) {
		user object = null;
		
		try {
			String query = "Select * from userTable where email=? and password=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, email);
			ptst.setString(2, pass);
			
			ResultSet rst = ptst.executeQuery();
			
			while(rst.next()) {
				object = new user();
				object.setId(rst.getInt(1));
				object.setName(rst.getString(2));
				object.setEmail(rst.getString(3));
				object.setPassword(rst.getString(4));
				object.setQual(rst.getString(5));
				object.setRole(rst.getString(6)); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public user findUserDetails(int id) {
		user object = new user();
		
		try {
			String query = "Select * from userTable where id=?";
		    PreparedStatement ptst = con.prepareStatement(query);
		    ptst.setInt(1, id);
		    
		    ResultSet rst = ptst.executeQuery();
		    
		    while(rst.next()) {
		    	object.setId(rst.getInt(1));
		    	object.setName(rst.getString(2));
		    	object.setEmail(rst.getString(3));
		    	object.setPassword(rst.getString(4));
		    	object.setQual(rst.getString(5));
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public boolean editProfile(int id, String name, String email, String pass, String qual) {
		
		try {
			String query = "update userTable set name=?, email=?, password=?, qual=? where id=?";
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, name);
			ptst.setString(2, email);
			ptst.setString(3, pass);
			ptst.setString(4, qual);
			ptst.setInt(5, id);
			
			
			int check = ptst.executeUpdate();
		    if(check==1) {
		    	return true;
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
