package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class CoursTest {

	@Test
	public void test() {
		CourseSession course = CourseSession.create(01, "English");
		assertEquals(01, course.getCourseNum());
		assertEquals("English", course.getCourseName());

	}

	@Test
	public void test2() {
		Student stu1 = new Student("song");
		Student stu2 = new Student("jia");
		Student stu3 = new Student("gao");
		CourseSession course1 = CourseSession.create(01, "English");
		course1.enroll(stu1);
		course1.enroll(stu2);
		course1.enroll(stu3);
		assertEquals(stu3, course1.indexStu(2));
	}

	@Test
	public void test3() throws ParseException {
		//测试开始时间
		Date date = new Date();
		Calendar sc = Calendar.getInstance();
		sc.set(2016, 11, 1);
		date = sc.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		CourseSession course = CourseSession.create(01, "English", date);
		String startDate = sdf.format(date);
		assertEquals(startDate, sdf.format(course.getStartDate()));
		//测试结束时间
		Calendar ec = Calendar.getInstance();
		ec.set(2017, 5, 1);
		Date date1 = new Date();
		date1 = ec.getTime();
		String endDate = sdf.format(date1);
		assertEquals(endDate, sdf.format(course.getEndDate()));
		//测试不传日期，自动生成的时间
		CourseSession course2 = CourseSession.create(02, "Math");
        assertEquals(startDate, sdf.format(course2.getStartDate()));
	}

	@Test
	@SuppressWarnings("unused")
	public void test4() {
		CourseSession course = CourseSession.create(01, "English");
		CourseSession course2 = CourseSession.create(02, "Math");
		CourseSession course3 = CourseSession.create(03, "Java");
		assertEquals(3, course3.getCourseNum());
	}

}
