package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSession {
       private int courseNum;//课程编号
       private String courseName;//课程名字
       private int stuInCourse = 0;
       private Date date;
       private static List<Student> allStus = new ArrayList<Student>();//注册List
       public CourseSession(int courseNum, String courseName){
    	   this.courseNum = courseNum;
    	   this.courseName = courseName;
       }
       //获取课程的编号
       public int getCourseNum(){
		return courseNum;
       }
       //获取课程的名字
       public  String getCourseName(){
    	   return courseName;
       }
       public CourseSession(Date date){
    	   
       }
       //给学生注册,注册的同时并统计有多少人注册了课程
       public static void enroll(Student student){
    	   allStus.add(student);
       }
       //获得课程的学生个数
       public int getNumberOfStudents(){
		return stuInCourse;
       }
       //获取注册的学生
       public List<Student> getAllStudents(){
		return allStus;
       }
       //获取第n个注册的学生
       public Student indexStu(int index){
    	   return allStus.get(index);
       }
       //获得开课时间
       public Date getStartDate(){
		
       }
       //课程结束时间
       public Date getEndDate(){
		return null;
    	   
       }
}
