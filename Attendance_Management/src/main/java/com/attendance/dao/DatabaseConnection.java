package com.attendance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	public Connection getConnection(){
		Connection con = null;
		Statement st = null;
		String url = "jdbc:mysql://localhost:3306/attendance_management";
		String user = "projectuser";
		String password = "1234";
		try {
			System.out.println("Connecting tot he server...");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		/*	boolean result = st.execute("Select version");
			System.out.println("Database Connected " + result);
		*/} catch (SQLException se) {
			se.printStackTrace();
		}
	return con;
	}
}
