package com.zizaitianyuan.javac2.practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RosterReporter {
	private CourseSession course;

	public RosterReporter(CourseSession course) {
		this.course = course;
	}

	public String getReporter() {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");// 定义输出时间格式
		String studentName = "";
		for (int i = 0; i < CourseSession.allStudent.size(); i++) {
			studentName = studentName + CourseSession.allStudent.get(i).getName();
		}
		String message = "课程名称：" + course.getDepartment() + "课程编号：" + course.getNumber() + "学生总数："
				+ course.getAllStudents() + "开课日期:" + formatDate.format(course.getStartDate()) + "结束日期"
				+ formatDate.format(course.getEndDate()) + "\n" + studentName;
		return message;
	}
}
