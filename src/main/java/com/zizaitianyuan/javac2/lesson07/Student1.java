package com.zizaitianyuan.javac2.lesson07;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Student1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Date date = new Date();
		CourseSession course = CourseSession.create("102", "English");  //初始化一个CourseSession对象
		RosterReporter report = new RosterReporter(course);   //初始化一个RosterReporter对象
		Student[] student = new Student[] { new Student("Leon"), new Student("leone"), new Student("leono") };
		for (Student s : student) {  //用enroll（）方法将学生输入enList
			course.enroll(s);
		}
		System.out.println(report.getReport());  //调用文本方法

	}

}

class Student {   //创建学生的类
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

	public boolean isFullTime() {
		return credits >= 12;
	}

	public int getCredits() {
		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public boolean isLocal() {
		return LOCAL.equals(this.province);
	}

	public void setLocaltion(String province) {
		this.province = province;
	}
}

class CourseSession {   //创建一个课程的类
	static List<Student> enList = new ArrayList<Student>();
	private String number;
	private String department;
	private Date startDate;
	private Date endDate;
	private static String ymd = "yyyy-MM-dd"; //日期输出格式 
	private static int count;

	private CourseSession(String number, String department) {   
		this(number, department, new GregorianCalendar(2016, 10 + 1, 1).getTime());   //调用三个参数的构造函数，我这里不会用Calendar生成当前日期

	}

	private CourseSession(String number, String department, Date startDate) {
		this.number = number;
		this.department = department;
		this.startDate = startDate;
		incrementCount();
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudent() {
		return enList.size();
	}

	public void enroll(Student student) {
		enList.add(student);
		this.getCount();
	}

	// public List<Student> getAllStudents(){
	// return enList;
	// }

	public Student get(int index) {
		return enList.get(index);
	}

	Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStartDate());
		cal.add(Calendar.MONTH, +6);
		endDate = cal.getTime();
		return endDate;
	}

	public String formated1() {   
		SimpleDateFormat sim = new SimpleDateFormat(ymd);
		return sim.format(getStartDate());
	}

	public String formated2() {
		SimpleDateFormat sim = new SimpleDateFormat(ymd);
		String a = sim.format(getEndDate());
		return a;
	}

	public int getCount() {
		return count;
	}

	private static void incrementCount() {
		count++;
	}

	static CourseSession create(String number, String department) {  //两参的工厂方法
		return new CourseSession(number, department);
	}

	static CourseSession create(String number, String department, Date startDate) { 
		return new CourseSession(number, department, startDate);
	}
}

class RosterReporter {

	CourseSession course;

	public RosterReporter(CourseSession course) {
		this.course = course;
	}

	public String getReport() {  //输出的文本方法
		String bag = "课程编号：" + course.getNumber() + "\t课程名称：" + course.getDepartment() + "\t参加本门课程人数："
				+ course.getNumberOfStudent() + "\t开始与截止日期：" + course.formated1() + "~" + course.formated2() + "\n\n";
		bag = bag + "参加本门课程学生姓名：\n";
		for (int i = 0; i < course.getNumberOfStudent(); i++) {
			bag = bag + "\t\t" + course.get(i) + "\n";
		}
		return bag;
	}
}

class StudentTest {   //测试

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
		Calendar cal = new GregorianCalendar(year, month, day);
		return cal.getTime();
	}

	// public int getDays(){
	// Calendar cal;
	//
	// }
}

class CourseReport {   
	static List<CourseSession> courseList = new ArrayList<CourseSession>();

	public void add(CourseSession course) {
		courseList.add(course);
	}

	public String text() {
		String bag2 = null;		
		for(int i = 1;i<courseList.size();i++) {
			bag2 += "\t" + i + courseList.get(i-1);
		}
		return bag2;
	}
}
