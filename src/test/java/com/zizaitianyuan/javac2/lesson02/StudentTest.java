package com.zizaitianyuan.javac2.lesson02;

import static org.junit.Assert.*;

import org.junit.Test;

import com.course.Student;

public class StudentTest {
	Student student = new Student("Jia");
	Student student1 = new Student("Rui");
	Student student2 = new Student("JiaRui");

	@Test
	public void testGetGPA1() {
		double a = 8.0 / 3;
		student.addGrade("A");
		student.addGrade("B");
		student.addGrade("D");
		assertEquals(a, student.getGPA(), 0.01);
	}

	@Test
	public void testGetGPA2() {
		double a = 0.0;
		student1.addGrade("F");
		student1.addGrade("F");
		student1.addGrade("F");
		assertEquals(a, student1.getGPA(), 0.01);
	}

	@Test
	public void testGetGPA3() {
		double a = 8.0 / 3;
		student2.addGrade("a");
		student2.addGrade("b");
		student2.addGrade("d");
		assertEquals(a, student2.getGPA(), 0.01);
	}

}
