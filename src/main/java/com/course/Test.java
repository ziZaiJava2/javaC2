package com.course;

import java.util.Date;

public class Test {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		CourseSession courseSession = CourseSession.create("English", "104", date);
		RosterReporter ros = new RosterReporter(courseSession);
		Student[] student = new Student[] { new Student("Leon"), new Student("Tom"), new Student("Jack"),
				new Student("Mary") };
		for (Student student1 : student) {
			enrolling(courseSession, student1);
		}
		System.out.println(ros.getReport());
	}

	private static void enrolling(CourseSession courseSession, Student student) {
		courseSession.enroll(student);
	}
}
