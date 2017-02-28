package com.attendance.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import com.attendance.dao.DatabaseConnection;
import com.attendance.dao.StudentDao;
import com.attendance.main.Attendance_Management.Student;

public class StudentDaoImpl implements StudentDao {

	Connection conn = null;
	DatabaseConnection dataSource = new DatabaseConnection();
	
	public Student getStudentDetails(int id) {
		System.out.println("in method");
		String sql = "Select * from student where rollno =" + id;
		Student std = new Student();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			if (rs.next()) {
				std.setFirstName(rs.getString("first_name"));
				std.setFirstName(rs.getString("first_name"));
				std.setRollNum(rs.getString("rollno"));
			} else {
				std = null;
			}
		} catch (SQLException se) {
			System.out.println("Error Occurred");
			se.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return std;
	}

	public void saveDate(String prsnce, int rollNum, String date) {
		if(prsnce.equals("P"))
			prsnce = "true";
		else
			prsnce = "false";
		String sql = "insert into attendance values("+rollNum +","+prsnce+",STR_TO_DATE('"+date+"','%m/%d/%Y' ))";
		System.out.println(sql);
		conn = dataSource.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Attendance saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showAllStudentsOnDate(String Date, int teacherId) {
		conn = dataSource.getConnection();
	String sql = "select * from attendance where teacherId = " + teacherId +"and attd_Date = " +Date+ ")";
	PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	} 
}