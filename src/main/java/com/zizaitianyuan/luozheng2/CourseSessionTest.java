package com.zizaitianyuan.luozheng2;

import java.util.Date;

import org.junit.Assert;

public class CourseSessionTest {
	public static void testCourseSession() {
		CourseSession c = new CourseSession("102","English",new Date());
		CourseSession c1 = new CourseSession("103","java",new Date());
		CourseSession c2 = new CourseSession("104","java",new Date());
		Student s1 = new Student("Love");
		Student s2 = new Student("Me");
		Student s3 = new Student("Forever");
		c.enroll(s1);
		c.enroll(s2);
		c.enroll(s3);
		Assert.assertEquals(3, c.getNumberOfStudents());
		Assert.assertEquals(s3, c.get(2));
		System.out.println(c.getStartDate());
		System.out.println(c.getEndDate());
		RosterReporter r = new RosterReporter(c);
		System.out.println(r.getReport());
		Assert.assertEquals(3, c.getCount());
		Assert.assertEquals(0, s1.getCredits());
		s1.addCredits(12);
		Assert.assertEquals(true, s1.isFullTime());
		s1.setLocal("shanghai");
		Assert.assertEquals(true, s1.isLocal());
	}
}
