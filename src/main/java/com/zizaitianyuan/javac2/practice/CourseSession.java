package com.zizaitianyuan.javac2.practice;

import java.util.Date;

public class CourseSession {
private String classId;
private String className;
private static int NumberofStudent;	
private String enroll;
private static Date startDate;

	

	public static  int getNumberofStudent() {
	
		
	return 0;
}
    public   void enroll(Student student){
    	
    }
    public void get(int index){
    	
    }


	public CourseSession(String className,String classId) {
		this(className, classId, startDate);
		
		
	
	}
	
	public CourseSession(String className,String classId,Date startDate){
		this.classId=classId;
		this.className=className;
		this.startDate=startDate;
		
	}


	private void startDate() {
		
		
	}
	public String getClassId() {
		return this.classId;
	}

	public String getClassName() {
		return this.className;
	}

	public static void main(String[] args) {
		CourseSession classDemo=new CourseSession("English","102");
		getNumberofStudent();
	}

}
