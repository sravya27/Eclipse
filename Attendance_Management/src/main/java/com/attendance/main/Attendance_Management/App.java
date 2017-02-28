package com.attendance.main.Attendance_Management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.attendance.dao.StudentDao;
import com.attendance.daoImpl.StudentDaoImpl;

/**
 * Hello world!
 *
 */
public class App {
	
	private StudentDao studentDao;

	public static void main(String[] args) throws ParseException {
		App a = new App();
		System.out.println("Enter your rollno below:");
		Scanner scan = new Scanner(System.in);
		int rollNum = scan.nextInt();
		Student st = a.findStudent(rollNum);
		if (st != null){
			System.out.println(
					"Hi " + st.getFirstName() + "," + st.getLastName() + " if present enter 'P' else enter 'A' and enter Date in MM/DD/YYYY format");
		String present = scan.next();
		String date = scan.next();
		a.saveStudentAttendance(present,rollNum,date);
		}
		else
			System.out.println("Not a Student");
	}

	public Student findStudent(int id) {		
		studentDao = new StudentDaoImpl();
		Student student = studentDao.getStudentDetails(id);
		return student;
	}

	public void saveStudentAttendance(String prsnce, int rollNum, String date){
		studentDao = new StudentDaoImpl();
		studentDao.saveDate(prsnce, rollNum, date);
	}
}
