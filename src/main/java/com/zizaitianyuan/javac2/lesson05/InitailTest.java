package com.zizaitianyuan.javac2.lesson05;

import org.junit.Assert;
import org.junit.Test;

public class InitailTest {

	@Test
	public void test() {
		Student leon = new Student("Leon");
		Assert.assertEquals("Leon", leon.getName());
	}
	
	@Test
	public void test2() {
		CourseSession English = new CourseSession("English" , "102");
		Assert.assertEquals("English", English.getNumber());
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
		Assert.assertEquals(stu3, english.get(2));		//��һ�в���д
		
	}
}
