package com.zizaitianyuan.luozheng2;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CourseSession {// 课程的类
	String number;// 课程编号
	String department;// 课程名称
	int numberOfStu = 0;
	List<Student> students = new LinkedList<Student>();
	Date date;
	private static int count;

	CourseSession(String number, String department, Date date) {
		this.number = number;
		this.department = department;
		//  创建 Calendar 对象  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		this.date = calendar.getTime();
		incrementCount();
	}

	CourseSession(String number, String department) {
		this.number = number;
		this.department = department;
	}

	public String getDepartment() {// 获取课程名称
		return department;
	}

	public String getNumber() {// 获取课程编号
		return number;
	}

	public int getNumberOfStudents() {
		return numberOfStu;
	}

	public void enroll(Student student) {
		students.add(student);
		numberOfStu++;
	}

	public Student get(int index) {
		return students.get(index);

	}

	public Date getStartDate() {// 为开课日期
		return date;
	}

	public Date getEndDate() {// 为开课日期六个月之后的日期
		//  创建 Calendar 对象  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 6);
		Date EndDate = calendar.getTime();
		return EndDate;
	}

	public static int getCount() {
		return count;
	}

	private static void incrementCount() {
		count += 1;
	}

	public static CourseSession create(String number, String department) {
		CourseSession c = new CourseSession(number, department);
		return c;
	}

	public static CourseSession create(String number, String department, Date date) {
		CourseSession c = new CourseSession(number, department, date);
		return c;

	}
}
