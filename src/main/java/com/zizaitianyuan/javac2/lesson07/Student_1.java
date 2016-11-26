package com.zizaitianyuan.javac2.lesson07;
import org.java
import java.util.ArrayList;
import java.util.List;
public class Student_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


class Student{
	private String name;
	
	public Student(String n){
		this.name = n;
	}
	public String getName(){
		return name;
	}
}

class CourseSession{
	private String courseNum;
	private String courseName;
	static List<Student> list = new ArrayList<Student>();
	
	public CourseSession(String num,String name){
		this.courseNum = num;
		this.courseName = name;
	}
	
	public String getDepartment(){
		return courseName;
	}
	
	public String getNumber(){
		return courseNum;
	}
	
	public int getNumberOfStudents(){
		return list.size();
	}
	
	public void enroll(Student student){
		list.add(student);
	}
}

class StudentTest{
	
	@Test
	public void testCreateStudent(){
		Student leon = new Student("Leon");
		Assert.assertEquals("Leon",leon.getName());
	}
}

class CourseSessionTest{
	
	@Test
	public void testCreateStudent(){
	CourseSession english = new CourseSession("102","English");
	Assert.assertEquals("102",english.getNumber());
	Assert.assertEquals("English",english.getDepartment());
	}
	
	@Test
	public void test
}
	
	
	
	
	
	
	
	
