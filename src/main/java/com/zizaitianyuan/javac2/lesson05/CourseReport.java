package com.zizaitianyuan.javac2.lesson05;

import java.util.ArrayList;
import java.util.List;

public class CourseReport {

	private static List<CourseSession> report = new ArrayList<CourseSession>();
	
	public void add(CourseSession course){
		this.report.add(course);
	}
	
	public String text(){
		
		return null;
	}
}
