package com.zizaitianyuan.javac2.lesson05;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.zizaitianyuan.javac2.lesson05.Student;

public class InitailTest {

	@Test
	public void test() {
		Student leon = new Student("Leon");
		Assert.assertEquals("Leon", leon.getName());
	}
	
	@Test
	public void test2() {
		CourseSession English = new CourseSession("English" , "102");
		Assert.assertEquals("English", English.getDepartment());
	}
	
	@Test
	public void test3() {
		CourseSession english = new CourseSession("English" , "102");
		english.getNumberOfStudents();
		Assert.assertEquals(0, english.getNumberOfStudents());
	}
	
	@Test
	public void test4() {
		CourseSession english = new CourseSession("English" , "102");
		Student stu1 = new Student("Mike");
		Student stu2 = new Student("Duke");
		english.enroll(stu1);
		english.enroll(stu2);
		Assert.assertEquals(2, english.getNumberOfStudents());
	}
	
	@Test
	public void test5() {
		CourseSession english = new CourseSession("English" , "102");
		Student stu1 = new Student("Mike");
		Student stu2 = new Student("Duke");
		english.enroll(stu1);
		english.enroll(stu2);
		Assert.assertEquals(2, english.getNumberOfStudents());
		Assert.assertEquals(stu1, english.get(0));		
		Assert.assertEquals(stu2, english.get(1));
	}
	
	@Test
	public void test6() {
		CourseSession english = new CourseSession("English" , "102");
		Student stu1 = new Student("Duke1");
		Student stu2 = new Student("Duke2");
		Student stu3 = new Student("Duke3");
		english.enroll(stu1);
		english.enroll(stu2);
		english.enroll(stu3);
		Assert.assertEquals(stu3, english.get(2));		
		
	}
	
	@Test
	public void test7() {
		CourseSession english = new CourseSession("English" , "102");
		Date date = english.getStartDate();
		Assert.assertEquals(date,"2006-12-21 0:00:00 星期五");		
		english = new CourseSession("English" , "102", date);  //这个测试不会写
		Assert.assertEquals(date,"2006-12-21 0:00:00 星期五");	
	}
	
	@Test
	public void test9() {
		int a = CourseSession.getCount();
		CourseSession english = new CourseSession("English" , "102");
		CourseSession math = new CourseSession("English" , "102");
		CourseSession java = new CourseSession("English" , "102");
		Assert.assertEquals(3, CourseSession.getCount() - a );	
	}
}
