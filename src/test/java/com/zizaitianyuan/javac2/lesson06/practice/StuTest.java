package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.zizaitianyuan.javac2.lesson06.practice.Student.grade;

public class StuTest {

	@Test
	public void test1() {
		Student stu = new Student("Leom");
		assertEquals("Leom", stu.getName());
	}
	@Test
	public void test2(){
		Student stu = new Student("Leom");
		assertEquals(false, stu.isFullTime());
	}
	@Test
	public void test3(){
		Student stu = new Student("Leom");
		stu.addCredits(15);
		assertEquals(true, stu.isFullTime());
		Student stu2 = new Student("Leom");
		stu2.addCredits(11);
		assertEquals(false, stu2.isFullTime());
	}
	@Test
	public void test4(){
		Student stu1 = new Student("Leom");
		stu1.setLocation("昆仑");
		assertEquals(false, stu1.isLocal());
		Student stu2 = new Student("jiarui");
		stu2.setLocation(Student.LOCAL);
		assertEquals(true, stu2.isLocal());
	}
   @Test
   public void gpaGradeTest(){
	   Student stu = new Student("贾瑞");
	   stu.addGrade(grade.A);
	   stu.addGrade(grade.B);
	   assertEquals(3.5, stu.getGPA(), 0.0001);
	   Student stu2 = new Student("梁教官");
	   stu2.setHonors();
	   stu2.addGrade(grade.A);
	   stu2.addGrade(grade.B);
	   assertEquals(4.5, stu2.getGPA(), 0.0001);
   }
   
	   
   
}
