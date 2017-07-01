package com.zizaitianyuan.luozheng2;

import org.junit.Assert;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("Leon");
		System.out.println(s1.getName());
		StudentTest.testCreateStudent();
		CourseSession c = new CourseSession("102", "English");
		CourseSessionTest.testCourseSession();

	}

}
