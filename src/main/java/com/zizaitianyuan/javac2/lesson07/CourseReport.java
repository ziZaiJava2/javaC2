package com.zizaitianyuan.javac2.lesson07;

import java.util.ArrayList;
import java.util.List;

public class CourseReport {
	static List<CourseSession> courseList = new ArrayList<CourseSession>();

	public void add(CourseSession course) {
		courseList.add(course);
	}

	public String text() {
		String bag2 = null;
		for (int i = 1; i < courseList.size(); i++) {
			bag2 += "\t" + i + courseList.get(i - 1);
		}
		return bag2;
	}
}
