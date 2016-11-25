package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CourseCountTest {

	@Test
	public void test() {
		CourseSession course1 = CourseSession.create(01, "English");
		CourseSession course2 = CourseSession.create(01, "Math");
		CourseSession course3 = CourseSession.create(01, "Java");
		Assert.assertEquals(3, course3.getCourseCount());
	}

}
