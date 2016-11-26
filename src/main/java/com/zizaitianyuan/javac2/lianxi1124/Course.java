package com.zizaitianyuan.javac2.lianxi1124;

public class Course {
	public static void main(String[] args) {
		CourseSession course = new CourseSession("102", "English");
		Student stu1 = new Student("11");
		Student stu2 = new Student("22");
		Student stu3 = new Student("33");
		Student stu4 = new Student("44");
		course.enroll(stu1);
		course.enroll(stu2);
		course.enroll(stu3);
		course.enroll(stu4);
		RosterReporter reporter = new RosterReporter(course);
		System.out.println(reporter.getReport());
	}

}
