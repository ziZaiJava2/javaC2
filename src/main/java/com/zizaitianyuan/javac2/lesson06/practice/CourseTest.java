package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CourseTest {

	@Test
	public void test() {
		CourseSession course = new CourseSession(102, "English");
		Assert.assertEquals(102, course.getCourseNum());
		Assert.assertEquals("English", course.getCourseName());
	}
	
	public void test2(){
		Student stu01 = new Student("Leom");
		Student stu02 = new Student("song");
		CourseSession course01 = new CourseSession(102, "English");
		CourseSession course02 = new CourseSession(102, "");
	
	}

}
