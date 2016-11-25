package com.zizaitianyuan.javac2.lianxi1124;

import java.util.ArrayList;
import java.util.List;

import com.zizaitianyuan.javac2.lesson06.Student;

public class CourseSession {
	public List<Student> allStudent = new ArrayList<Student>();
	private String courseNumber;
	private String courseDepartment;
	
	//创建一个构造函数，接受课程编号(String)，和课程名称(String)，作为名字。
	public CourseSession(String courseNumber, String courseDepartment) {
		this.courseNumber = courseNumber;
		this.courseDepartment = courseDepartment;

	}
	
	//创建一个getNumber()的方法来获取课程编号
	public String getNumber() {

		return courseNumber;

	}
	
    //创建一个getDepartment()的方法来获取课程名称。
	public String getDepartment() {

		return courseDepartment;

	}
	
	//添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量。
	public int getNumberOfStudents() {

		return allStudent.size();

	}

	//添加一个新方法enroll(Student student),用来给这门课注册学生。
	public void enroll(Student student) {

		allStudent.add(student);

	}
	
	public List<Student> getAllStudents() {
		List<Student> AllStudent = new ArrayList<Student>();
	}

}