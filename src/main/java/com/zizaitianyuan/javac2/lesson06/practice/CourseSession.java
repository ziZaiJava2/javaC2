package com.zizaitianyuan.javac2.lesson06.practice;

public class CourseSession {
       private int courseNum;
       private String courseName;
       public CourseSession(int courseNum, String courseName){
    	   this.courseNum = courseNum;
    	   this.courseName = courseName;
       }
       public int getCourseNum(){
		return courseNum;
       }
       public String getCourseName(){
    	   return courseName;
       }
}
