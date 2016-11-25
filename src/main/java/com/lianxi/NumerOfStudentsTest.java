package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NumerOfStudentsTest {
//	�µĲ���case������һ��English�Ŀγ̣�assertĬ��getNumberOfStudents()����ֵΪ0
	@Test
	public void test() {
		CourseSession lesson = new CourseSession("102","English");
		Assert.assertEquals(0, lesson.getNumberOfStudents());
	}

}
