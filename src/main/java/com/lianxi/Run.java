package com.lianxi;

public class Run {
	public void main(String[] args){
		CourseSession lesson = new CourseSession("102","English");
		Student firstStu = new Student("一个人");
		Student secondStu = new Student("两个人");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		
		System.out.println(lesson.getNumberOfStudents());
	}
}
