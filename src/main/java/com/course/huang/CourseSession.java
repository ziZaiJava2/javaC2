package com.course.huang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession {
	

	public SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd ");
	public Calendar c = Calendar.getInstance();
	public List<Student> course = new ArrayList<Student>();
	
	private String courseNum;
	private String courseName;
	private Date startDate;
	private Date endDate;
	private static int count = 0 ;
	  
	
	private CourseSession(String courseName, String courseNum){
		this(courseName, courseNum, null);
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);


	}
	
	private CourseSession(String courseName, String courseNum,Date startDate){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.startDate = startDate;	
		CourseSession.incrementCount();
	}
	
	public static int getCount(){
		return CourseSession.count;
	}
	
	private static void incrementCount(){
		CourseSession.count ++;
	}
	
	public Date getStartDate() {
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);
		return c.getTime();
	}
	
	public Date getEndDate() {
		Calendar c = new GregorianCalendar();
		c.setTime(this.startDate);
		c.add(Calendar.MONTH, 6);
		return c.getTime();
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
	
	public static CourseSession creatTwoParameters (String courseName, String courseNum){
		
		return new CourseSession(courseName, courseNum);
		
	}
	
	public static CourseSession creatThreeParameters(String courseName, String courseNum, Date startDate){
	
		return new CourseSession(courseName, courseNum, startDate);
		
	}
}


