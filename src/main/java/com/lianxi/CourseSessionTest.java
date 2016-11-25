package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CourseSessionTest {

	@Test
	public void testCreatCourse() {
		CourseSession lesson = new CourseSession("102","English");
		Assert.assertEquals("102", lesson.getNumber());
		Assert.assertEquals("English", lesson.getDepartment());
	}

}
