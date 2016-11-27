package com.zizaitianyuan.javac2.lesson06.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RosterReporter {
	private CourseSession courseSession;

	public RosterReporter(CourseSession courseSession) {
		this.courseSession = courseSession;
	}

	public String getReport() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		//获取时间信息
		String startTime = sdf.format(courseSession.getStartDate());
		String endTime = sdf.format(courseSession.getEndDate());
		//获取课程信息
		String courseMessage = "课程：" + courseSession.getCourseName() + " " + 
		                       "课程编号：" + courseSession.getCourseNum() + " " 
				             + "课程人数：" + " "
				+ courseSession.getNumberOfStudents();
		
		String timeMessage = "开课时间：" + " " + startTime + " " + "课程结束时间：" + endTime;
		String stuMessage = "";
		
		for (int i = 0; i < courseSession.getNumberOfStudents(); i++) {
			stuMessage = stuMessage + courseSession.indexStu(i).getName() + "\n";
		}
		
		String allMessage = courseMessage + " " + "\n" + timeMessage + " " + " \n" + stuMessage;
		return allMessage;
	}
}
