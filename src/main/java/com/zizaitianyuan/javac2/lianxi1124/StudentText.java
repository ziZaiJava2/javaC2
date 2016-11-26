package com.zizaitianyuan.javac2.lianxi1124;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class StudentText {

	private CourseSession english;

	// 添加一个测试方法测试学生，创建一个学生实例，名字叫做Leon,然后assert他的getName()方法返回的名字是Leon。
	@Test
	public void testCreateStudent() {
		Student leon = new Student("Leon");

		Assert.assertEquals("Leon", leon.getName());
	}

	// 添加一个测试方法测试课程，创建一个English，编号102的课程实例
	@Test
	public void testCreateStudent1() {
		CourseSession courseSession = new CourseSession("102", "English");
		Assert.assertEquals("102", courseSession.getNumber());
		Assert.assertEquals("English", courseSession.getDepartment());
	}

	// 新的测试case，创建一个English的课程，assert默认getNumberOfStudents()返回值为0
	@Test
	public void testCreateStudent2() {
		CourseSession course = new CourseSession("102", "English");
		course.getDepartment();
		Assert.assertEquals(course.getNumberOfStudents(), 0);
	}

	@Test
	public void getEndDateTest() throws ParseException {
		String startStr = "2016-01-01";
		String endStr = "2016-07-01";
		String formatStr = "YYY-MM-DD";
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date startDate = format.parse(startStr);
		Date expectEndDate = format.parse(endStr);

		CourseSession cs = new CourseSession("java", "001", startDate);
		Date endDate = cs.getEndDate();

		Assert.assertTrue(expectEndDate.getTime() == endDate.getTime());
	}
}
