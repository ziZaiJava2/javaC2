package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseReport{
	private static List<CourseSession> courseList = new ArrayList<>();
	public void add(CourseSession course) {
          courseList.add(course);
	}
	public String text(){
		Collections.sort(courseList, new Comparator<CourseSession>() {

			@Override
			public int compare(CourseSession o1, CourseSession o2) {
				// TODO Auto-generated method stub
				return o1.getCourseName().compareTo(o2.getCourseName());
			}
		});
		String nameList = "课程名单：" + "\n";
		for(CourseSession courseName : courseList){
			nameList = nameList + courseName.getCourseName() + "\n";
		}
		return nameList;
	}

}
