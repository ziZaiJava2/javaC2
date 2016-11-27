package com.lianxi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//创建开一个课程的类(CourseSession),要求：
//有一个构造函数，接受课程编号(String)，和课程名称(String)，作为名字。

public class CourseSession {
	private String number;
	private String course;
	private List<Student> line = new ArrayList<Student>();
	private Date open;
//	添加一个静态字段count来统计总共有的课程数
	private static int count;


	public CourseSession(String num, String course) {
		this(num, course, new GregorianCalendar(Calendar.YEAR, Calendar.MONTH + 2, 1).getTime());
	}

	public CourseSession(String num, String course, Date date) {
		this.number = num;
		this.course = course;
		this.open = date;
		count++;
	}

//提供一个getDepartment()的方法来获取课程名称。
	public String getDepartment() {
		return this.course;
	}

//提供一个getNumber()的方法来获取课程编号
	public String getNumber() {
		return this.number;
	}

//	测试一下自己的代码，你可以通过main方法来做。保证case通过
//
//	生成一个学生实例，他的名字叫做Leon，可以通过getName()获取这个名字
//	生成一门课程的实例，课程名称是English,编号是102，可以通过对应方法获取课程名称和编号
//	如果你想更进一步，创建两个Test的类，添加单元测试
//
//	添加一个测试方法测试学生，创建一个学生实例，名字叫做Leon,然后assert他的getName()方法返回的名字是Leon。类似于这样。
	public void main(String[] args) {
		Student stu = new Student("Leon");
		CourseSession lesson = new CourseSession("102", "English");
		System.out.println(
				"姓名" + stu.getName() + " 课程号" + lesson.getNumber() + " 课程名" + lesson.getDepartment());
	}

//	添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量
	    public int getNumberOfStudents() {
		return this.line.size();
	}

//	    添加一个新方法enroll(Student student),用来给这门课注册学生。
	public void enroll(Student student) {
		line.add(student);
	}

//	添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。
	// public List<Student> getAllStudents(){
	// return this.line;
	// }

//	添加新方法get(int index), 返回第index个注册的学生
	public Student get(int index) {
		return this.line.get(index - 1);
	}

//	添加方法getStartDate()，返回Date类型，为开课日期
	public Date getStartDate() {
		return this.open;
	}

//	添加方法getEndDate()，返回Date类型，为开课日期六个月之后的日期。
	public Date getEndDate(){
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStartDate());
		cal.add(Calendar.MONTH, +6);
		Date day = cal.getTime();
		return day;
	}


	public static int getCount() {
		return count;
	}

}
