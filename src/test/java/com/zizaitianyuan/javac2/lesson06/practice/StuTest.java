package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StuTest {

	@Test
	public void test() {
		Student stu = new Student("Leom");
		Assert.assertEquals("Leom", stu.getName());
	}

}
