package com.zizaitianyuan.luozheng2;

import org.junit.Assert;

public class StudentTest {
	public static void testCreateStudent() {
		Student leon = new Student("Leon");
		Assert.assertEquals("Leon", leon.getName());
	}

}
