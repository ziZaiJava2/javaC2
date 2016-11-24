package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.Calendar;
import java.util.Date;

public class StudentTest {

	public static void main(String[] args) {
		   Calendar c = Calendar.getInstance();
		   c.set(2016, 11, 1);
           Date date = new Date();
           date = c.getTime();
           CourseSession courseSession = new CourseSession(01, "English",date);
    	   Student stu1 = new Student("song");
    	   Student stu2 = new Student("jia");
    	   Student stu3 = new Student("gao");
    	   Student stu4 = new Student("laing");
    	   courseSession.enroll(stu1);
    	   courseSession.enroll(stu2);
    	   courseSession.enroll(stu3);
    	   courseSession.enroll(stu4);
    	   RosterReporter roster = new RosterReporter(courseSession);
    	   System.out.println(roster.getReport());
	}

}
