package com.zizaitianyuan.javac2.lianxi1124;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseReport {
	private static List<CourseSession> courseList = new ArrayList<>();
	
	public static void add(CourseSession course) {
		courseList.add(course);
	}
	/*
	 * 添加text()方法到CourseReport类，返回字符串，每行名字加编号，按照课程的名字升序排列
                  想想我们在CourseReport中用什么数据结构来保存add进来的课程对象
                  这次我们不在自己写排序算法了，使用Collections.sort()方法来排序
	 */
	//百度的
	public String text(){
		Collections.sort(courseList, new Comparator<CourseSession>() {

			@Override
			public int compare(CourseSession o1, CourseSession o2) {
				
				return o1.getcourseName().compareTo(o2.getcourseName());
			}			
		});
		String name = "课程名字" + "\n";
		/*
		 * List里面的CourseSession类型的courseName元素内容取出来，调用getcourseName()取出课程名
		 */
		for (CourseSession courseName : courseList) {
			name = name + courseName.getcourseName() + "\n";
		}
		return name;
		
		
	}

}
