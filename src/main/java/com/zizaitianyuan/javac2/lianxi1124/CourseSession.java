package com.zizaitianyuan.javac2.lianxi1124;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession {
	private Date startDate;
	private String courseName;
	private int courseNumber;
	private static int count = 0;
	public static List<Student> allStudent = new ArrayList<Student>();


	/*
	 *  创建一个构造函数，接受课程编号(String)，和课程名称(String)，作为名字。
	 */
	CourseSession(int courseNumber, String courseName) {
		this(courseNumber, courseName, null);
	}

	/*
	 *  添加一个新的构造函数，这次接受三个参数，课程名称，课程编号，开课日期。这里日期使用Date类型
	 */
	CourseSession(int courseNumber, String courseName, Date startDate) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.startDate = startDate;
		count++;
		


	}

	/*
	 *  创建一个getNumber()的方法来获取课程编号
	 */
	public int getNumber() {

		return courseNumber;

	}

	/*
	 *  创建一个getDepartment()的方法来获取课程名称。
	 */
	public String getcourseName() {

		return courseName;

	}

	/*
	 *  添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量。
	 */
	public int getNumberOfStudents() {

		return allStudent.size();

	}

	/*
	 *  添加一个新方法enroll(Student student),用来给这门课注册学生。
	 */
	public void enroll(Student student) {

		allStudent.add(student);

	}

	 /*
	  *  添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。
	 /*
	 public List<Student> getAllStudents() {
	 return this.allStudent;
	 }
	 

	/*
	 *  添加新方法get(int index), 返回第index个注册的学生
	 */
	public Student indexStudent(int index) {

		return allStudent.get(index);

	}

	
	/*
	 *  添加方法getStartDate()，返回Date类型，为开课日期
	 */
	public Date getStartDate() {
		Calendar c =Calendar.getInstance();
		/*
		 * alendar类中,月份是从0开始的,+1用来表示1到12月
		 */
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);
		startDate = c.getTime();
		return startDate;
	}

	/*
	 * 添加方法getEndDate()，返回Date类型，为开课日期六个月之后的日期。
	 */
	public Date getEndDate() {		
		Calendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		cal.add(Calendar.MONTH, 6);
		return cal.getTime();

	}

	public static int getCourseCount() {
		return count;
	}
	
/*
 * public static CourseSession create(int courseNumber, String courseName) {
 
		CourseSession course = new CourseSession(courseNumber, courseName);
		Course report = new Course();
		report.add(course);
		return course;
	}

	public static CourseSession create(int courseNum, String courseName, Date date) {
		CourseSession course = new CourseSession(courseNum, courseName, date);
		CourseReport report = new CourseReport();
		report.add(course);
		return course;
	}
*/
}