package com.zizaitianyuan.javac2.lesson06.practice;

import java.sql.Date;
import java.util.List;

public class RosterReporter {
	   private CourseSession courseSession;
       public RosterReporter(CourseSession courseSession){
    	   this.courseSession = courseSession;
       }
       public String getReport(){
    	   courseSession = new CourseSession(01, "English");
    	   Student stu1 = new Student("song");
    	   Student stu2 = new Student("jia");
    	   Student stu3 = new Student("gao");
    	   Student stu4 = new Student("laing");
    	   courseSession.enroll(stu1);
    	   courseSession.enroll(stu2);
    	   courseSession.enroll(stu3);
    	   courseSession.enroll(stu4);
    	   String name = courseSession.getCourseName();
    	   int num = courseSession.getCourseNum();
    	   Date sDate = (Date) courseSession.getStartDate();
    	   Date eDate = (Date) courseSession.getEndDate();
    	   String courseMessage = "课程：" +  name + "课程编号：" + num + "课程人数：" + courseSession.getNumberOfStudents();
    	   String timeMessage = "开课时间：" + sDate + "课程结束时间：" + eDate;
    	   String stuMessage = null;
    	   for(int i = 0; i < courseSession.getNumberOfStudents(); i++){
    		   stuMessage = stuMessage + courseSession.getAllStudents().get(i) + "\n";
    	   }
    	   String allMessage = courseMessage + timeMessage + stuMessage;
		    return allMessage;
       }
}
