package com.lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//这次我们要创建一个新的报表类，他收集课程，然后可以按课程名称排序
//	创建CourseReport类，有add(CourseSession course)方法，可以添加课程到report对象。
public class CourseReport {
	private List<CourseSession> report =new ArrayList<CourseSession>();
	public void add(CourseSession course){
		report.add(course);
	}
//	添加text()方法到CourseReport类，返回字符串，每行名字加编号，按照课程的名字升序排列
	public String text(){
		Collections.sort(report,new Comparator<CourseSession>()){
			@Override
			public int compare(CourseSession o1,CourseSession o2){
				return o1.getDepartment().compareTo()
			}
		};
	}
//	想想我们在CourseReport中用什么数据结构来保存add进来的课程对象
//	这次我们不在自己写排序算法了，使用Collections.sort()方法来排序
}
