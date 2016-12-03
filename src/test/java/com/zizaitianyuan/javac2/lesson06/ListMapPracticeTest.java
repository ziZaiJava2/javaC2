package com.zizaitianyuan.javac2.lesson06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ListMapPracticeTest {
	int[] studentIds = {100, 101, 102, 103, 104, 105, 106, 107};
	String[] studentNames = {"Wei Wei", "Huang Shi Feng", "Xiao Ming", "Xiao Gang", "Han Mei Mei", "Li Lei", "Liu De Hua", "Sun Yan Zi"};
	String[] studentMajor = {"Software Engineering", "Software Engineering", "Software Engineering", "Computer Science", "Computer Science", "Computer Science", "Computer Science", "Software Engineering"};
	
	@Test
	public void getStudentListMajoredInSoftwareEngineeringTest(){
		String[] studentNamesMajoredInSoftwareEngineering = {"Wei Wei", "Huang Shi Feng", "Xiao Ming", "Sun Yan Zi"};
		Set<String> set = new HashSet<String>(Arrays.asList(studentNamesMajoredInSoftwareEngineering));
		
		List<Student> studentListMajoredInSoftwareEngineering = ListMapPractice.getStudentListMajoredInSoftwareEngineering();
		for(Student student: studentListMajoredInSoftwareEngineering){
			String name = student.getName();
			Assert.assertTrue(set.contains(name));
		}
	}
	
	@Test
	public void getStudentListMajoredInComputerScienceTest(){
		String[] studentNamesMajoredInComputerScience = {"Xiao Gang", "Han Mei Mei", "Li Lei", "Liu De Hua"};
		Set<String> set = new HashSet<String>(Arrays.asList(studentNamesMajoredInComputerScience));
		
		List<Student> studentListMajoredInComputerScience = new List<Student>();
		for(Student student: studentListMajoredInComputerScience){
			String name = student.getName();
			Assert.assertTrue(set.contains(name));
		}
	}
	
	@Test
	public void constructStudentMapWithNameKeyTest(){
		Map<String, Student> studentMapWithNameKey = ListMapPractice.constructStudentMapWithNameKey();
		for(int i=0; i<studentNames.length; i++){
			String name = studentNames[i];
			String major = studentMajor[i];
			int id = studentIds[i];
			Student student = studentMapWithNameKey.get(name);
			Assert.assertNotNull(student);
			Assert.assertEquals(name, student.getName());
			Assert.assertEquals(major, student.getMajor());
			Assert.assertEquals(id, student.getId());
		}
	}
	
	@Test
	public void constructStudentMapWithIdKeyTest(){
		Map<Integer, Student> studentMapWithIdKey = ListMapPractice.constructStudentMapWithIdKey();
		for(int i=0; i<studentNames.length; i++){
			String name = studentNames[i];
			String major = studentMajor[i];
			int id = studentIds[i];
			Student student = studentMapWithIdKey.get(id);
			Assert.assertNotNull(student);
			Assert.assertEquals(name, student.getName());
			Assert.assertEquals(major, student.getMajor());
			Assert.assertEquals(id, student.getId());
		}
	}

}
