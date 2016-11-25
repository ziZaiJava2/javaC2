package com.zizaitianyuan.javac2.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CourseSessionTest {

	@Test
	public void testCase1() {
		 CourseSession classDemo=new CourseSession("English","102");
		 Assert.assertEquals("English",classDemo.getClassName());
		 Assert.assertEquals("102",classDemo.getClassId());
		 }
	@Test
	public void testCase2() {
		
	}
	

}
