package com.zizaitianyuan.luozheng2;

public class RosterReporter {// 用来生成一门课程的报告的
	CourseSession coursesession;

	public RosterReporter(CourseSession coursesession) {
		this.coursesession = coursesession;
	}

	public String getReport() {
		String s = coursesession.department + " " + coursesession.number + " " + coursesession.date + "~"
				+ coursesession.getEndDate() + "\n";
		for (int i = 0; i < coursesession.students.size(); i++) {
			s = s + "\n" + coursesession.students.get(i);
		}
		return s;
	}
}
