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
//	
	@Test
	public void test2() {
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
		Assert.assertEquals("English", english.getDepartment());
	}
	
	@Test
	public void test3() {
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
		english.getNumberOfStudents();
		Assert.assertEquals(0, english.getNumberOfStudents());
	}
	
	@Test
	public void test4() {
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
		Student stu1 = new Student("Mike");
		Student stu2 = new Student("Duke");
		english.enroll(stu1);
		english.enroll(stu2);
		Assert.assertEquals(2, english.getNumberOfStudents());
	}
	
	@Test
	public void test5() {
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
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
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
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
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
		Date date = english.getStartDate();
		Assert.assertEquals(date,"2016-11-27");		
		CourseSession math = CourseSession.creatThreeParameters("English" , "102", date);
		Assert.assertEquals(date,"2006-12-21 0:00:00 星期五");	
	}
	
	@Test
	public void test9() {
		int a = CourseSession.getCount();
		CourseSession english = CourseSession.creatTwoParameters("English" , "102");
		CourseSession math = CourseSession.creatTwoParameters("Math" , "102");
		CourseSession java = CourseSession.creatTwoParameters("java" , "102");
		Assert.assertEquals(3, CourseSession.getCount() - a );	
	}
	
	@Test
	public void test10() {
		Student stu = new Student("ren");
		Assert.assertFalse(stu.isFullTime());
		Assert.assertEquals(0, stu.getCredits() );	
		Student stu1 = new Student("xiang");
		stu1.addCredits(5);
		Assert.assertEquals(5, stu1.getCredits() ); 
		Student stu2 = new Student("jie");
		stu2.addCredits(12);
		Assert.assertEquals(true, stu2.isFullTime());
		Student stu3 = new Student("renxiang");
		stu3.addCredits(11);
		Assert.assertEquals(false, stu3.isFullTime());
		}
	
	public void test11() {
		Student stu = new Student("ren");
		Assert.assertFalse( stu.isLocal());
		Student stu1 = new Student("xiang");
		stu1.setLocation(stu1.LOCAL);
		Assert.assertTrue( stu1.isLocal());

		
		}
}
