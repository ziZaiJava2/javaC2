package com.zizaitianyuan.javac2.lesson07;

public class RosterReporter {
	CourseSession course;

	// 创建一个文本的构造方法
	public RosterReporter(CourseSession course) {
		this.course = course;
	}

	public String getReport() { // 输出的文本方法
		String bag = "日期：" + course.formated() + "\n课程编号：" + course.getNumber() + "\t课程名称：" + course.getDepartment()
				+ "\t参加本门课程人数：" + course.getNumberOfStudent() + "\t课程开始与截止日期：" + course.formated1() + "~"
				+ course.formated2() + "\n\n";
		bag = bag + "参加本门课程学生姓名：\n";
		for (int i = 0; i < course.getNumberOfStudent(); i++) {
			bag = bag + "\t\t" + course.get(i) + "\n";
		}
		return bag;
	}
}
