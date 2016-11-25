package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.Calendar;
import java.util.Date;

public class StudentTest {

	public static void main(String[] args) {
		   Calendar c = Calendar.getInstance();
		   c.set(2016, 11, 1);
           Date date = new Date();
           date = c.getTime();
           CourseSession course1 = CourseSession.create(01, "01English", date);
           CourseSession course2 = CourseSession.create(01, "03Math", date);
           CourseSession course3 = CourseSession.create(01, "02Java", date);
    	   Student stu1 = new Student("song");
    	   Student stu2 = new Student("jia");
    	   Student stu3 = new Student("gao");
    	   Student stu4 = new Student("laing");
    	   course1.enroll(stu1);
    	   course1.enroll(stu2);
    	   course1.enroll(stu3);
    	   course1.enroll(stu4);
    	   RosterReporter roster = new RosterReporter(course1);
    	   System.out.println(new CourseReport().text());
    	   System.out.println(roster.getReport());
	}

}
