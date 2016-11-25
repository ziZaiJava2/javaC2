package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class EnrollTest {
//	�µĲ���case������һ��English�Ŀγ̣������ſγ�ʹ��enroll(student)����ע������ѧ����assert����getNumberOfStudents()����2.
	@Test
	public void test() {
		CourseSession lesson = new CourseSession("102","English");
		Student firstStu = new Student("һ����");
		Student secondStu = new Student("������");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		Assert.assertEquals(2, lesson.getNumberOfStudents());
	}

}
