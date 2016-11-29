package com.zizaitianyuan.javac2.practice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.experimental.theories.internal.AllMembersSupplier;

public class CourseSession {
	public CourseSession(String classId2, String classId) {
		
		this(classId2, classId, null);
		
		Calendar calender = Calendar.getInstance();

		calender.set(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH) + 1, 1);

		startDate = calender.getTime();
	}

	public CourseSession(String classId2, String classId, Date startDate) {
		this.getNumber();
		this.getDepartment();
		this.startDate = startDate;
		count++;

	}
	private String classId;
	private String depertment;

	public static  List<Student> allStudent = new ArrayList<Student>();
	private  Date startDate;
	private static int count = 0;

	
	private static int getNumberofStudent() {

		return allStudent.size();
	}

	/**
	 * 给这门课注册学生
	 * 
	 * @return
	 */
	public  void enroll(Student student) {
		allStudent.add(student);
	}

	/**
	 * 返回第index个注册的学生
	 * 
	 * @return
	 */
	public Student get(int index) {
		return allStudent.get(index - 1);
	}

	/**
	 * 返回包含所有通过enroll()方法注册的学生的List。
	 */

	public int getAllStudents() {

		return allStudent.size();

	}

	/**
	 * 返回一个Date类型的开课日期
	 *
	 */
	public Date getStartDate() {
       
		return startDate;

	}

	/**
	 * 返回Date类型，为开课日期六个月之后的日期
	 */

	public Date getEndDate() {

		Calendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		cal.add(Calendar.MONTH, 6);
		return cal.getTime();

	}
	public static int incrementCount() {

		return count;

	}
	

	/**
	 * 接收课程编号
	 */
	public String getNumber() {

		return this.classId;
	}

	/**
	 * 接收课程名称
	 */
	public String getDepartment() {
		return this.depertment;
	}
	public void setDepartment(String department) {

		incrementCount();

		this.depertment = department;
	}
	public static CourseSession create(String classId, String department) {

		CourseSession course = new CourseSession(classId, department);

		ClassReport report = new ClassReport();

		report.add(course);

		return course;

	}
	public static CourseSession create(String classId, String department, Date date) {

		CourseSession course = new CourseSession(classId, department);

		ClassReport report = new ClassReport();

		report.add(course);

		return course;

	}
	

}
