package com.zizaitianyuan.javac2.lesson03;

import org.junit.Assert;
import org.junit.Test;

public class OverloadingTest {

	
	@Test
	public void testAdd() {
		int result = Mathmatics.add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Assert.assertEquals(55, result);
	}
	
	@Test
	public void testSub() {
		int result = Mathmatics.sub(10, 5);
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void testSub2() {
		double result = Mathmatics.sub(10, 5);
		Assert.assertTrue(result == 5.0);
	}
}
