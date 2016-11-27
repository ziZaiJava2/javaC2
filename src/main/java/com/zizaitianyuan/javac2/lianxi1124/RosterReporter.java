package com.zizaitianyuan.javac2.lianxi1124;

import java.text.SimpleDateFormat;

public class RosterReporter {
	// 这个新的类有一个构造函数，接受CourseSession对象。
	private CourseSession reporter;

	public RosterReporter(CourseSession reporter) {
		this.reporter = reporter;
	}

	public String getReport() {
		// 定义输出时间格式
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		// 构造一个课程，注册4名学生，然后通过这个新的类打印一个报告出来
		String studentName = "";
		for (int i = 0; i < CourseSession.allStudent.size(); i++) {
			studentName = studentName + CourseSession.allStudent.get(i).getName() + "\n";
		}

		// 这个新的类有一个方法getReport()，返回一个字符串。字符串是对于构造函数传入的课程的描述:
		String Reporter = ("课程名称：" + reporter.getcourseName() + " "+ "编号" + reporter.getNumber() + " "+"参加学习学生总数"
				+ reporter.getNumberOfStudents() + " "+"开课日期"  + format1.format(reporter.getStartDate()) + "结束日期"
				+ format1.format(reporter.getEndDate()) +"\n"+ studentName );
		return Reporter;

	}

}
