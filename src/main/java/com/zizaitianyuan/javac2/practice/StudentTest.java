package com.zizaitianyuan.javac2.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

	@Test // 添加一个测试方法测试学生，创建一个学生实例，名字叫做Leon,然后assert他的getName()方法返回的名字是Leon。
	public void StudentTest() {
		
		Student leon = new Student("Leon");
		
		Assert.assertEquals("Leon", leon.getName());
	}

	@Test
	public void CreateStudentTest() {

		CourseSession courseSession = new CourseSession("102", "English");

		Assert.assertEquals("102", courseSession.getNumber());

		Assert.assertEquals("English", courseSession.getDepartment());

	}

}
