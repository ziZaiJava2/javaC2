package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class GetTest {
//	�µĲ���case������һ��English�Ŀγ̣������ſγ�ʹ��enroll(student)����ע��3��ѧ����ͨ��get(2)��ȡѧ����assert����enroll�ĵ�����ѧ���ǲ���ͬһ����
	@Test
	public void test() {
		CourseSession lesson = new CourseSession("102","English");
		Student firstStu = new Student("һ����");
		Student secondStu = new Student("������");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		Assert.assertEquals(secondStu, lesson.get(2));
	}

}
