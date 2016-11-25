package com.lianxi;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class GetAllStudentsTest {

	@Test
	public void test() {
		CourseSession lesson = new CourseSession("102","English");
		Student firstStu = new Student("һ����");
		Student secondStu = new Student("������");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		List<Student> line = new List<Student>();
		line.add(firstStu);
		line.add(secondStu);
		Assert.assertEquals(line, lesson.getAllStudents());;
	}

}
