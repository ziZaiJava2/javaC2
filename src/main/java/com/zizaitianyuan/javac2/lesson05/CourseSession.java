package com.zizaitianyuan.javac2.lesson05;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zizaitianyuan.javac2.lesson05.Student;

public class CourseSession {
	

	public SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd ");
	public Calendar c=Calendar.getInstance();
	public List<Student> course = new ArrayList<Student>();
	
	private String courseNum;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private static int Count = 0 ;
	  
	
	public CourseSession(String courseName, String courseNum){
		CourseSession.incrementCount();
		this.courseName = courseName;
		this.courseNum = courseNum;
	}
	
	public CourseSession(String courseName, String courseNum,Date startDate){
		this(courseName, courseNum);
		this.startDate = startDate;
	}
	
	public static int getCount(){
		return CourseSession.Count;
	}
	
	private static void incrementCount(){
		CourseSession.Count ++;
	}
	
	public Date getStartDate() {
			Date date=new Date();
			date.setYear(116);
			date.setMonth(11);
        	date.setDate(1);
//        date.setMinutes(0);
//        date.setHours(0);
//        date.setSeconds(0);
		return this.startDate = date ;
	}
	
	public Date getEndDate() {
		startDate.setYear(117);
		startDate.setMonth(5);
		startDate.setDate(1);
//		startDate.setMinutes(0);
//		startDate.setHours(0);
//		startDate.setSeconds(0);
		endDate = startDate;
		return endDate;
	}
	
	public String getDepartment(){
		return this.courseName;
	}
	
	public String getNumber(){
		return this.courseNum;
	}
	
	public void enroll(Student student){
		
		course.add(student);
	}
	
	public int getNumberOfStudents(){

		return course.size();
	}
	
//	public List<Student> getAllStudents(){
//		List<Student> enrollStudent = new ArrayList<Student>();
//		for(Student a : course) {
//			enrollStudent.add( a );
//		}	
//		return enrollStudent;
//	}
	
	public Student get(int index){
		
		return course.get(index);	
		 
	}
}


