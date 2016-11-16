package com.zizaitianyuan.javac2.lesson02;

<<<<<<< HEAD
import org.junit.Assert;
import org.junit.Test;

public class Practice4Test {

	@Test
	public void testCase1(){
		int[] sourceArray= {5, 8, 6, 5, 0, 0, 9, 2, 1};
		int[] expecteds = {0, 0, 1, 2, 5, 5, 6, 8, 9};
		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));
	}
	
	@Test
	public void testCase2(){
		int[] sourceArray= {0, 0, 0, 0, 0};
		int[] expecteds = {0, 0, 0, 0, 0};
		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));
	}
	
	@Test
	public void testCase3(){
		int[] sourceArray= {1, 2, 3, 4, 5};
		int[] expecteds = {1, 2, 3, 4, 5};
		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));
	}
	
	@Test
	public void testCase4(){
		int[] sourceArray= {6, 5, 4, 3, 2};
		int[] expecteds = {2, 3, 4, 5, 6};
		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));
	}
	
	@Test
	public void testCase5(){
		int[] sourceArray= {};
		int[] expecteds = {};
		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));
	}
}
=======


import org.junit.Assert;

import org.junit.Test;



public class Practice4Test {



	@Test

	public void testCase1(){

		int[] sourceArray= {5, 8, 6, 5, 0, 0, 9, 2, 1};

		int[] expecteds = {0, 0, 1, 2, 5, 5, 6, 8, 9};

		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));

	}

	

	@Test

	public void testCase2(){

		int[] sourceArray= {0, 0, 0, 0, 0};

		int[] expecteds = {0, 0, 0, 0, 0};

		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));

	}

	

	@Test

	public void testCase3(){

		int[] sourceArray= {1, 2, 3, 4, 5};

		int[] expecteds = {1, 2, 3, 4, 5};

		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));

	}

	

	@Test

	public void testCase4(){

		int[] sourceArray= {6, 5, 4, 3, 2};

		int[] expecteds = {2, 3, 4, 5, 6};

		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));

	}

	

	@Test

	public void testCase5(){

		int[] sourceArray= {};

		int[] expecteds = {};

		Assert.assertArrayEquals(expecteds, Practice4.sort(sourceArray));

	}

}
>>>>>>> d727d4b... practice4
