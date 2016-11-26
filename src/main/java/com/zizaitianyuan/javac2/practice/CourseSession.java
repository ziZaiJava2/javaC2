package com.zizaitianyuan.javac2.practice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.experimental.theories.internal.AllMembersSupplier;

public class CourseSession {
	public CourseSession(String className, String classId) {
		this(className, classId, startDate);

	}

	public CourseSession(String className, String classId, Date startDate) {
		this.getNumber();
		this.getDepartment();
		this.startDate = startDate;

	}
	private String classId;
	private String className;

	private static List<Student> allStudent = new ArrayList<Student>();
	private static Date startDate;

	private static int getNumberofStudent() {

		return allStudent.size();
	}

	/**
	 * 给这门课注册学生
	 * 
	 * @return
	 */
	public static void enroll(Student student) {
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

	public List getAllStudents() {

		return allStudent;

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
		return this.className;
	}

	public static void main(String[] args) {
		// CourseSession courseSession=
	}

	public static CourseSession create() {
		// TODO 自动生成的方法存根
		return null;
	}

}
