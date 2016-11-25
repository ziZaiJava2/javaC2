package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StuTest {

	@Test
	public void test1() {
		Student stu = new Student("Leom");
		Assert.assertEquals("Leom", stu.getName());
	}
	@Test
	public void test2(){
		Student stu = new Student("Leom");
		Assert.assertEquals(false, stu.isFullTime());
	}
	@Test
	public void test3(){
		Student stu = new Student("Leom");
		stu.addCredits(15);
		Assert.assertEquals(true, stu.isFullTime());
		stu.addCredits(11);
		Assert.assertEquals(false, stu.isFullTime());
	}
	@Test
	public void test4(){
		Student stu1 = new Student("Leom");
		stu1.SetLocation("昆仑");
		Assert.assertEquals(false, stu1.isLocal());
		Student stu2 = new Student("jiarui");
		stu2.SetLocation(Student.local);
		Assert.assertEquals(true, stu2.isLocal());
	}

}
