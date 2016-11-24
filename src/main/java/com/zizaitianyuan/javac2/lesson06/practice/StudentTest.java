package com.zizaitianyuan.javac2.lesson06.practice;

public class StudentTest {

	public static void main(String[] args) {
           Student stu1 = new Student("Leom");
           System.out.print("姓名：" + stu1.getName() + " ");
           CourseSession course1 = new CourseSession(1, "java开发");
           System.out.print("课程：" + course1.getCourseName() + " ");
           System.out.print("课程编号:" + course1.getCourseNum());
	}

}
