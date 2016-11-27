package com.zizaitianyuan.javac2.lesson06.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class CourseSession {
	private int courseNum;// 课程编号
	private String courseName;// 课程名字
	private static int count = 0;// 课程数量
	private Date date;
	private List<Student> allStus = new ArrayList<Student>();// 注册List

	/**
	 * 
	 * @param courseNum
	 * @param courseName
	 * @param date
	 */
	private CourseSession(int courseNum, String courseName) {
		this(courseNum, courseName, null);
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);
		date = c.getTime();
	}

	private CourseSession(int courseNum, String courseName, Date date) {
		this.courseNum = courseNum;
		this.courseName = courseName;
		count++;
		this.date = date;
	}

	/**
	 * 这个方法接收课程编号
	 * 
	 * @return
	 */
	public int getCourseNum() {
		return courseNum;

	}

	/**
	 * 接收课程名字
	 * 
	 * @return
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 给学生注册,注册的同时并统计有多少人注册了课程
	 * 
	 * @param student
	 */
	public void enroll(Student student) {
		allStus.add(student);
	}

	/**
	 * 获取第n个注册的学生
	 * 
	 * @param index
	 * @return
	 */
	public Student indexStu(int index) {
		return allStus.get(index);
	}


	/**
	 * 返回一个课程的list用于统计他的长度计算人数
	 * 
	 * @return
	 */
	public int getNumberOfStudents() {
		return allStus.size();
	}

	/**
	 * 获得开课时间
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return date;
	}

	/**
	 * 课程结束时间
	 * 
	 * @return
	 * @throws ParseException
	 */

	public Date getEndDate() throws ParseException {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, 6);
		Date endDate = c.getTime();
		return endDate;
	}

	/**
	 * 返回添加的课程数量
	 * 
	 * @return
	 */
	public static int getCourseCount() {
		return count;
	}

	public static CourseSession create(int courseNum, String courseName) {
		CourseSession course = new CourseSession(courseNum, courseName);
		CourseReport report = new CourseReport();
		report.add(course);
		return course;
	}

	public static CourseSession create(int courseNum, String courseName, Date date) {
		CourseSession course = new CourseSession(courseNum, courseName, date);
		CourseReport report = new CourseReport();
		report.add(course);
		return course;
	}
}
