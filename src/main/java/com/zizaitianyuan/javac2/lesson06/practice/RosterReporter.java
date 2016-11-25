package com.zizaitianyuan.javac2.lesson06.practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RosterReporter {
	   private CourseSession courseSession;
       public RosterReporter(CourseSession courseSession){
    	   this.courseSession = courseSession;
       }
       public String getReport(){
    	   String name = courseSession.getCourseName();
    	   int num = courseSession.getCourseNum();
    	   SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    	   Date sDate = courseSession.getStartDate();
    	   String startTime = sdf.format(sDate);
    	   Date eDate =  courseSession.getEndDate();
    	   String endTime = sdf.format(eDate);
    	   String courseMessage = "课程：" +  name + " " + "课程编号：" + num + " " + "课程人数：" + " " + courseSession.getNumberOfStudents();
    	   String timeMessage = "开课时间：" + " " + startTime + " " +"课程结束时间：" + endTime;
    	   String stuMessage = "";
    	   for(int i = 0; i < courseSession.getNumberOfStudents(); i++){
    		   stuMessage = stuMessage + courseSession.getAllStudents().get(i).getName() + "\n";
    	   }
    	   String allMessage = courseMessage + " " + "\n" + timeMessage + " " + " \n" + stuMessage;
		    return allMessage;
       }
}
