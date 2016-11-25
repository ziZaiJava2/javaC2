package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CourseReportTest {

	@Test
	public void test() {
		CourseSession course1 = CourseSession.create(01, "01English");
		CourseSession course2 = CourseSession.create(01, "03Math");
		CourseSession course3 = CourseSession.create(01, "02Java");
		String name = "01English" + "\n" + "02Java" + "\n" + "03Math" + "\n";
		String expect = "课程名单：" + "\n" + name;
        Assert.assertEquals(expect, new CourseReport().text());
}
}