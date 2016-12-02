package com.zizaitianyuan.javac2.lesson07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession {
	List<Student> enList = new ArrayList<Student>(); // 课程的学生链表
	private String number; // 课程编号
	private String department; // 课程名称
	private Date startDate; // 开始日期
	private static Date date = new Date(); // 生成系统今日日期 或者用 Calendar
											// c=Calendar.getInstance();
	private Date endDate; // 结束日期
	private static String ymd = "yyyy-MM-dd"; // 日期输出格式
	private static int count; // 课程数

	private CourseSession(String number, String department) {
		this(number, department, getDate1()); // 调用三个参数的构造函数，我这里不会用Calendar生成当前日期

	}

	private CourseSession(String number, String department, Date startDate) {
		this.number = number;
		this.department = department;
		this.startDate = startDate;
		incrementCount();
	}

	public String getDepartment() {
		return department; // 返回课程名称
	}

	public String getNumber() {
		return number; // 返回课程编号
	}

	public int getNumberOfStudent() {
		return enList.size(); // 返回this课程的学生人数，即enList链表的大小
	}

	public void enroll(Student student) {
		enList.add(student); // 将学生加入enList链表
		// this.getCount();
	}

	// public List<Student> getAllStudents(){
	// return enList;
	// }

	public Student get(int index) {
		return enList.get(index); // 返回该课程某个学生
	}

	public static Date getDate() {
		return date;
	}

	// 返回开始日期
	public static Date getDate1() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date); // 更改系统生成的今日日期date
		cal.add(Calendar.MONTH, +1); // 月份+1
		cal.set(Calendar.DAY_OF_MONTH, 1); // 日为1
		Date date1 = cal.getTime(); // 新建一个date1接受
		return date1; // 返回开始日期
	}

	// 返回输入开始日期
	public Date getStartDate() {
		return this.startDate; // 返回课程开始日期
	}

	// 返回结束日期
	public Date getEndDate() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStartDate());
		cal.add(Calendar.MONTH, +6);
		endDate = cal.getTime();
		return endDate;
	}

	// 将Date类型的开始日期，转换为String类型
	public String formated1() {
		DateFormat format = new SimpleDateFormat(ymd);
		String time = format.format(getStartDate());
		return time;
	}

	// 将Date类型的结束日期，转换为String类型
	public String formated2() {
		DateFormat format = new SimpleDateFormat(ymd);
		String time = format.format(getEndDate());
		return time;
	}

	// 将Date类型的系统生成的今日日期，转换为String类型
	public String formated() {
		DateFormat format = new SimpleDateFormat(ymd);
		String time = format.format(date);
		return time;
	}

	// 返回课程数
	public int getCount() {
		return count;
	}

	// 静态，增加课程数
	private static void incrementCount() {
		count++;
	}

	// 工厂方法
	static CourseSession create(String number, String department) {
		return new CourseSession(number, department);
	}

	static CourseSession create(String number, String department, Date startDate) {
		return new CourseSession(number, department, startDate);
	}
}

