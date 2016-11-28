package com.course.huang;

import java.util.ArrayList;
import java.util.Collections;
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
