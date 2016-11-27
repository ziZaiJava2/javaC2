package com.zizaitianyuan.javac2.lesson07;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Student1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入日期：" + "\t\t(格式：2015--08--06)");

		// 将String类型的输入日期，转化为Date类型
		String str = input.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = null;
		try {
			inputDate = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CourseSession course = CourseSession.create("102", "English", inputDate); // 初始化一个CourseSession对象
		RosterReporter report = new RosterReporter(course); // 初始化一个RosterReporter对象
		Student[] student = new Student[] { new Student("Leon"), new Student("leone"), new Student("leono") };
		for (Student s : student) { // 用enroll（）方法将学生输入enList
			course.enroll(s);
		}
		System.out.println(report.getReport()); // 调用文本方法

	}

}

class Student { // 创建学生的类
	private String name;
	private int credits;
	private String province;
	private static final String LOCAL = "SH";

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name;
	}

	public boolean isFullTime() { // 判断全日制学生
		return credits >= 12;
	}

	public int getCredits() { // 返回学生的学分
		return credits;
	}

	public void addCredits(int credits) { // 添加学分方法
		this.credits += credits;
	}

	public boolean isLocal() { // 判断学生籍贯
		return LOCAL.equals(this.province);
	}

	public void setLocaltion(String province) { // 学生籍贯的输入
		this.province = province;
	}

	public double getGAP() { // 返回学生平均成绩
		return this.getCredits();
	}

	public void addGrade(String grade) { // 普通学生添加学分
		switch (grade) {
		case "A":
			this.addCredits(4);
			break;

		case "B":
			this.addCredits(3);
			break;

		case "C":
			this.addCredits(2);
			break;

		case "D":
			this.addCredits(1);
			break;

		case "F":
			this.addCredits(0);
			break;
		}

	}

	public int setHonors(String grade) { // 荣誉学生添加分数
		this.addGrade(grade);
		return this.getCredits() + 1;
	}
}

// 创建一个课程的类
class CourseSession {
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

// 创建一个文本类
class RosterReporter {
	CourseSession course;

	// 创建一个文本的构造方法
	public RosterReporter(CourseSession course) {
		this.course = course;
	}

	public String getReport() { // 输出的文本方法
		String bag = "日期：" + course.formated() + "\n课程编号：" + course.getNumber() + "\t课程名称：" + course.getDepartment()
				+ "\t参加本门课程人数：" + course.getNumberOfStudent() + "\t课程开始与截止日期：" + course.formated1() + "~"
				+ course.formated2() + "\n\n";
		bag = bag + "参加本门课程学生姓名：\n";
		for (int i = 0; i < course.getNumberOfStudent(); i++) {
			bag = bag + "\t\t" + course.get(i) + "\n";
		}
		return bag;
	}
}

class StudentTest { // 测试

	// @Test
	// public void testCreateStudent(){
	// Student leon = new Student("Leon");
	// Assert.assertEquals("Leon", leon.getName());
	// }
	// }
	//
	// class CourseSesssionTest{
	//
	// @Test
	// public void testCreateCourseSession(){
	// CourseSession english = new CourseSession("102","English");
	// Assert.assertEquals("102", english.getNumber());
	// Assert.assertEquals("English", english.getDepartment());
	// }
	// @Test
	// public void testCreateSession(){
	// CourseSession english = new CourseSession("102","English");
	// Assert.assertEquals(0, english.getNumberOfStudent());
	// }
	//
	// @Test
	// public void testCreateSession1(){
	// CourseSession english = new CourseSession("102","English");
	// Student leon = new Student("Leon");
	// Student leone = new Student("Leone");
	// english.enroll(leon);
	// english.enroll(leone);
	// Assert.assertEquals(2,english.getNumberOfStudent());
	// }
	//
	// @Test
	// public void testCreateSession2(){
	// CourseSession english = new CourseSession("102","English");
	// Student leon = null;
	// english.enroll(leon);
	// Student leone = null;
	// english.enroll(leone);
	//
	// Assert.assertEquals(leon,english.getAllStudents());
	// Assert.assertEquals(leone,english.getAllStudents());
	// }
	//
	// @Test
	// public void testCreateSession3(){
	// CourseSession english = new CourseSession("102","English");
	// Student leon = null;
	// english.enroll(leon);
	// Student leone = null;
	// english.enroll(leone);
	// Student leono = null;
	// english.enroll(leono);
	//
	// Assert.assertEquals(leono, english.get(2));
	// }
}

class DateUtil {
	private DateUtil() {
		// DateUtil du = new DateUtil();
	}

	public Date createDate(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day); // Date该方法已过时
		return cal.getTime(); // 调用该方法，将Calendar类型cal转化为Date类型
	}

	// 距离天数
	public String getDays(CourseSession course) {
		long time1 = course.getStartDate().getTime();
		long time2 = course.getEndDate().getTime();
		long time = CourseSession.getDate().getTime(); // System.currentTimeMillis();//与上面的相同,获取系统当前时间毫秒数
		String a = course.getDepartment() + "课程：" + "\n开始日期距离现在还有" + (time1 - time) + "天" + "\n结束日期距离现在还有"
				+ (time2 - time) + "天";
		return a;
	}

	public Date getFirstDate(Date date1, Date date2, Date date3) {
		Date firstDate = date1;
		if (date2.before(firstDate)) {
			firstDate = date2;
		} else if (date3.before(firstDate)) {
			firstDate = date3;
		}
		return firstDate;
	}
}

class CourseReport {
	static List<CourseSession> courseList = new ArrayList<CourseSession>();

	public void add(CourseSession course) {
		courseList.add(course);
	}

	public String text() {
		String bag2 = null;
		for (int i = 1; i < courseList.size(); i++) {
			bag2 += "\t" + i + courseList.get(i - 1);
		}
		return bag2;
	}
}
