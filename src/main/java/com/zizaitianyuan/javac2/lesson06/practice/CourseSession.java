package com.zizaitianyuan.javac2.lesson06.practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CourseSession {
       private int courseNum;//课程编号
       private String courseName;//课程名字
       static int count = 0;
       private Date date;
       private List<Student> allStus = new ArrayList<Student>();//注册List
       public CourseSession(int courseNum, String courseName){
    	   this.courseNum = courseNum;
    	   this.courseName = courseName;
    	   count++;
       }
       /**
        * 这个方法接收课程编号
        * @return
        */
       public int getCourseNum(){
		return courseNum;
		
       }
       /**
        * 接收课程名字
        * @return
        */
       public String getCourseName(){
    	   return courseName;
       }
       /**
        * 
        * @param courseNum
        * @param courseName
        * @param date
        */
       public CourseSession(int courseNum, String courseName, Date date){
    	   this(courseNum, courseName);
    	   this.date = date;
       }
       /**
        * 给学生注册,注册的同时并统计有多少人注册了课程
        * @param student
        */
       public void enroll(Student student){
    	   allStus.add(student);
       }
    
       /**
        * 获取第n个注册的学生
        * @param index
        * @return
        */
       public Student indexStu(int index){
    	   return allStus.get(index);
       }
       public List<Student> getAllStudents(){
    	   return allStus;
       }
       /**
        * 返回一个课程的list用于统计他的长度计算人数
        * @return
        */
       public int getNumberOfStudents(){
    	   return allStus.size();
       }
       /**获得开课时间
        * 
        * @return
        */
       public Date getStartDate(){  
		return date;
       }
       /**
        * 课程结束时间
        * @return
        */
       public Date getEndDate(){
    	Calendar c = Calendar.getInstance();
    	int year = c.get(Calendar.YEAR);
    	int month = c.get(Calendar.MONTH);
    	int day = 1;
    	if(month < 6){
    	    c.set(year , month + 5, day);
    	}else{
    		c.set(year + 1, 6-(11-month), day);
    	}
    	Date date = new Date();
    	date = c.getTime();
   		return date;
       }
}
