package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  练习要求， 按要求完善程序中的四个未完成的方法， 并且能够保证 ListMapPracticeTest 里的UT case都能够正确跑过。
 *  未完成的四个方法分别是：
 *  getStudentListMajoredInSoftwareEngineering()
 *  getStudentListMajoredInComputerScience()
 *  constructStudentMapWithNameKey()
 *  constructStudentMapWithIdKey()
 */

public class ListMapPractice {
	/*
	 * 初始化一个用来存储所有学生的List， 最后面的代码块用来构造一些学生对象 并把他们保存在 allStudents中
	 */
	public static ArrayList<Student> allStudents = new ArrayList<Student>();

	// 一个Map 用来存储学生信息， key是学生的名字， value是学生
	public static Map<String, Student> studentMapWithNameKey = new HashMap<String, Student>();

	// 一个Map 用来存储学生信息， key是学生的学号， value是学生
	public static Map<Integer, Student> studentMapWithIdKey = new HashMap<Integer, Student>();

	/*
	 * 从 allStudents 中找出主修专业为 "Software Engineering"的学生， 并保存在一个ArrayList中，并返回
	 */
<<<<<<< HEAD




	public static List<Student> getStudentListMajoredInSoftwareEngineering() {


		List<Student> majoredSoftwareEngineering = new ArrayList<Student>();
		for (Student temp : allStudents) {
			if ("Software Engineering".equals(temp.getMajor())) {
				majoredSoftwareEngineering.add(temp);
			}
		}

		return majoredSoftwareEngineering;

=======
	public static List<Student> getStudentListMajoredInSoftwareEngineering(){
		List<Student> MajoredSoftwareEngineering = new ArrayList<Student>();
		for(Student temp : allStudents){
			if("Software Engineering".equals(temp.getMajor())) {
				MajoredSoftwareEngineering.add(temp);
			}
		}
		
		return MajoredSoftwareEngineering;
		
>>>>>>> 86ef6d6... homework
	}

	/*
	 * 从 allStudents 中找出主修专业为 "Computer Science"的学生， 并保存在一个ArrayList中，并返回
	 */
<<<<<<< HEAD



	public static List<Student> getStudentListMajoredInComputerScience() {

		List<Student> majoredComputerScience = new ArrayList<Student>();
		for (Student temp : allStudents) {
			if ("Computer Science".equals(temp.getMajor())) {
				majoredComputerScience.add(temp);
			}
		}
		return majoredComputerScience;

=======
	public static List<Student> getStudentListMajoredInComputerScience(){
		List<Student> MajoredComputerScience = new ArrayList<Student>();
		for ( Student temp : allStudents){
			if("Computer Science".equals(temp.getMajor())) {
				MajoredComputerScience.add(temp);
			}
		}
		return MajoredComputerScience;
		
>>>>>>> 86ef6d6... homework
	}

	/*
	 * 通过 allStudents中保存的学生信息来构造一个 Map， 其中 key是学生的名字， value是学生,
	 * 以便以后可以快速的通过学生名字来查询学生的信息
	 */
<<<<<<< HEAD
	public static Map<String, Student> constructStudentMapWithNameKey() {
		for (Student temp : allStudents) {
			studentMapWithNameKey.put(temp.getName(), temp);
		}

		return studentMapWithNameKey;
	}

=======
	public static Map<String, Student> constructStudentMapWithNameKey(){		
		for(Student temp :allStudents) {
			studentMapWithNameKey.put(temp.getName(), temp); 
		}
		
		return studentMapWithNameKey;
	}
	 	
>>>>>>> 86ef6d6... homework
	/*
	 * 通过 allStudents中保存的学生信息来构造一个 Map， 其中 key是学生的学号， value是学生,
	 * 以便以后可以快速的通过学生学号来查询学生的信息
	 */
<<<<<<< HEAD
	public static Map<Integer, Student> constructStudentMapWithIdKey() {
		for (Student temp : allStudents) {
			studentMapWithIdKey.put(temp.getId(), temp);
=======
	public static Map<Integer, Student> constructStudentMapWithIdKey(){
		for(Student temp :allStudents) {
			studentMapWithIdKey.put(temp.getId(), temp); 
>>>>>>> 86ef6d6... homework
		}
		return studentMapWithIdKey;
	}

	/*
	 * 构造一些学生对象 并把他们保存在 allStudents中
	 */
	static {
		int[] studentIds = { 100, 101, 102, 103, 104, 105, 106, 107 };
		String[] studentNames = { "Wei Wei", "Huang Shi Feng", "Xiao Ming", "Xiao Gang", "Han Mei Mei", "Li Lei",
				"Liu De Hua", "Sun Yan Zi" };
		String[] studentMajor = { "Software Engineering", "Software Engineering", "Software Engineering",
				"Computer Science", "Computer Science", "Computer Science", "Computer Science",
				"Software Engineering" };

		for (int i = 0; i < studentNames.length; i++) {
			Student student = new Student();
			student.setId(studentIds[i]);
			student.setName(studentNames[i]);
			student.setMajor(studentMajor[i]);
			allStudents.add(student);
		}
	}



	


}

class Student {
	// 学号
	private int id;
	// 姓名
	private String name;
	// 专业
	private String major;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
