package com.zizaitianyuan.javac2.lianxi1124;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class StudentText {

    private CourseSession english;
	@Test
	public void testCreateStudent() {
	    Student leon = new Student("Leon");
	    Assert.assertEquals("Leon", leon.getName());
	}
	@Test
    public void testCreateStudent1() {
    CourseSession courseSession = new CourseSession("102","English");
    Assert.assertEquals("102",courseSession.getCourseNumber());
    Assert.assertEquals("English", courseSession.getDepartment());
    }
}
