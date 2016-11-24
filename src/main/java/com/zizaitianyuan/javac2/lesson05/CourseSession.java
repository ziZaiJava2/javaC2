package com.zizaitianyuan.javac2.lesson05;
import java.util.ArrayList;
import java.util.List;

public class CourseSession {
	
	public  List<Student> course = new ArrayList<Student>();
	
	private String courseNum;
	private String courseName;
	
	public CourseSession(String courseNum, String courseName){
		this.courseName = courseName;
		this.courseNum = courseNum;
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


