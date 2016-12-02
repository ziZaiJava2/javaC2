package com.zizaitianyuan.javac2.lesson07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入日期：" + "\t\t(格式：2015--08--06)");

		// 将String类型的输入日期，转化为Date类型
		String str = input.next();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate = null;
		try {
			inputDate = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CourseSession course = CourseSession.create("102", "English", inputDate); // 初始化一个CourseSession对象
		RosterReporter report = new RosterReporter(course); // 初始化一个RosterReporter对象
		Student[] student = new Student[] { new Student("Leon"), new Student("leone"), new Student("leono") };
		for (Student s : student) { // 用enroll（）方法将学生输入enList
			course.enroll(s);
		}
		System.out.println(report.getReport()); // 调用文本方法

	}

}



