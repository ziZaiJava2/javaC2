package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class CoursTest {


	@Test
	public void test() {
		CourseSession course = new CourseSession(01, "English");
	    Assert.assertEquals(01, course.getCourseNum());
	    Assert.assertEquals("English", course.getCourseName());
	}
	@Test
	public void test2(){
		Student stu1 = new Student("song");
		Student stu2 = new Student("jia");
		Student stu3 = new Student("gao");
		CourseSession course1 = new CourseSession(01, "English");
		course1.enroll(stu1);
		course1.enroll(stu2);
        course1.enroll(stu3);
        Assert.assertEquals(stu3, course1.indexStu(2));
	}
	@Test
	public void test3(){
		Date date = new Date();
		Calendar sc = Calendar.getInstance();
		sc.set(2016, 11, 1);
		date = sc.getTime();
		CourseSession course = new CourseSession(01, "English", date);
		Assert.assertEquals(date, course.getStartDate());
		Calendar ec = Calendar.getInstance();
		ec.set(2017, 5, 1);
		Date date1 = new Date();
		date1 = ec.getTime();
		Assert.assertEquals(date1, course.getEndDate());
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void test4(){
		CourseSession course1 = new CourseSession(01, "English");
		CourseSession course2 = new CourseSession(02, "Math");
		CourseSession course3 = new CourseSession(03, "Java");
		Assert.assertEquals(3, course3.getCourseNum());
	}

}
