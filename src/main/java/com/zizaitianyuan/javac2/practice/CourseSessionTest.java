package com.zizaitianyuan.javac2.practice;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class CourseSessionTest {

	@Test
	public void CourseSessionTest() {
		CourseSession classDemo = new CourseSession("English", "102");
		Assert.assertEquals("English", classDemo.getDepartment());
		Assert.assertEquals("102", classDemo.getNumber());
	}

	@Test
	public void getEndDateTest() throws  Exception {
		String startStr = "2016-01-01";
		String endStr = "2016-07-01";
		String formatStr = "YYYY-MM-DD";
		SimpleDateFormat format = new SimpleDateFormat("");
		Date startDate = format.parse(startStr);
		Date expectEndDate = format.parse(endStr);
		CourseSession cs = CourseSession.create(formatStr, formatStr);
		Date endDate = cs.getEndDate();
		Assert.assertTrue(expectEndDate.getTime() == endDate.getTime());
	}
	

}
