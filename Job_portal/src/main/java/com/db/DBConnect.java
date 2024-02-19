package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			if(con==null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "system";
				String pass = "aman123";
				
				con = DriverManager.getConnection(url,user,pass);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
