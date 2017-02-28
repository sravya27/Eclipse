package com.attendance.dao;

import java.util.Date;

import com.attendance.main.Attendance_Management.Student;

public interface StudentDao {

	Student getStudentDetails(int id);
	
	void saveDate(String prsnce, int rollNum, String date);
	
	void showAllStudentsOnDate(String Date, int teacherId);
}
