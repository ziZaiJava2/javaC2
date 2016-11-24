package Practice;

import java.util.ArrayList;

public class CourseSession {
	private String number;
	private String department;
	private ArrayList<String> les = new ArrayList<String>();

	public CourseSession(String number, String department) {
		this.number = number; 
		this.department = department;
	}

	public CourseSession() {
		// TODO Auto-generated constructor stub
	}

	public String getNumber() {
		return number;
	}

	public String getDepartment() {
		return department;
	}
	
	public int getNumberOfStudents(){
		return les.size();
	}
	
	public void enroll(String student){
		les.add(student);
	}
}
