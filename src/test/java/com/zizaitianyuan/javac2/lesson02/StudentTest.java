package com.zizaitianyuan.javac2.lesson02;

import static org.junit.Assert.*;

import org.junit.Test;

import com.course.Student;

public class StudentTest {
	Student student = new Student("Jia");
	Student student1=new Student("Rui");
	Student student2=new Student("JiaRui");
	@Test
	public void testAddGrade1() {
		student.addGrade("A");
		student.addGrade("B");
		student.addGrade("D");
	}
	@Test
	public void testGetGPA1() {
		double a = 8.0/3;
		assertEquals(a,student.getGPA(),0.01);
	}
	@Test
	public void testAddGrade2() {
		student1.addGrade("F");
		student1.addGrade("F");
		student1.addGrade("F");
	}
	@Test
	public void testGetGPA2() {
		double a = 0.0;
		assertEquals(a,student1.getGPA(),0.01);
	}
	@Test
	public void testAddGrade3() {
		student2.addGrade("a");
		student2.addGrade("b");
		student2.addGrade("d");
	}
	@Test
	public void testGetGPA3() {
		double a = 8.0/3;
		assertEquals(a,student2.getGPA(),0.01);
	}
	

}
