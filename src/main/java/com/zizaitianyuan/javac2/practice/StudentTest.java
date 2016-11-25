package com.zizaitianyuan.javac2.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

	@Test
	public void StudentTest() {
		 Student leon = new Student("Leon");
		 Assert.assertEquals("Leon", leon.getName());
	}

}
