package com.zizaitianyuan.javac2.lesson02;

import org.junit.Assert;
import org.junit.Test;

public class Practice3Test {

	@Test
	public void testcase2() {
		int[] source = new int[] {1, 2, 3, 4, 5};
		int[] newData = new int[] {3, 5, 6, 7, 8};
		
		Result result = Practice3.merge(source, newData);
		
		Assert.assertArrayEquals(result.inBoth, new int[]{3, 5, 0, 0, 0});
		Assert.assertArrayEquals(result.onlyInSource, new int[]{1, 2, 4, 0, 0});
		Assert.assertArrayEquals(result.notInSource, new int[]{6, 7, 8, 0, 0});
	}
	

	@Test
	public void testcase3() {
		int[] source = new int[] {1, 2, 3, 4, 5};
		int[] newData = new int[] {3, 5};
		
		Result result = Practice3.merge(source, newData);
		
		Assert.assertArrayEquals(result.inBoth, new int[]{3, 5, 0, 0, 0});
		Assert.assertArrayEquals(result.onlyInSource, new int[]{1, 2, 4, 0, 0});
		Assert.assertArrayEquals(result.notInSource, new int[]{0, 0, 0, 0, 0});
	}
	
	@Test
	public void testcase4() {
		int[] source = new int[] {};
		int[] newData = new int[] {};
		
		Result result = Practice3.merge(source, newData);
		
		Assert.assertArrayEquals(result.inBoth, new int[]{0, 0, 0, 0, 0});
		Assert.assertArrayEquals(result.onlyInSource, new int[]{0, 0, 0, 0, 0});
		Assert.assertArrayEquals(result.notInSource, new int[]{0, 0, 0, 0, 0});
	}
	
	@Test
	public void testcase5() {
		int[] source = new int[] {};
		int[] newData = new int[] {3, 5};
		
		Result result = Practice3.merge(source, newData);
		
		Assert.assertArrayEquals(result.inBoth, new int[]{0, 0, 0, 0, 0});
		Assert.assertArrayEquals(result.onlyInSource, new int[]{0, 0, 0, 0, 0});
		Assert.assertArrayEquals(result.notInSource, new int[]{3, 5, 0, 0, 0});
	}
}
