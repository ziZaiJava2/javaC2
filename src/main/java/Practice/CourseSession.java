package Practice;

import java.util.ArrayList;
import java.util.List;

public class CourseSession {
	private String number;
	private String department;
	// 某一门课的学生
	public static List<String> les = new ArrayList<String>();

	public CourseSession() {

	}

	public CourseSession(String number, String department) {
		this.number = number;
		this.department = department;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	// 添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量。
	public int getNumberOfStudents() {
		return les.size();
	}

	// 添加一个新方法enroll(Student student),用来给这门课注册学生。
	public void enroll() {
		Student stu = new Student();
		stu.setName(getDepartment());
		les.add(stu.getName());
	}

	// 添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。
	public List<Student> getAllStudents() {
		List<Student> all = new ArrayList<Student>();
		enroll();
		all.add(les);
		return all;
	}

	// 添加新方法get(int index), 返回第index个注册的学生。
	public int get(int index) {
		for (int i = 0; i < les.size(); i++) {
			if (index == i) {
				index = i;
			}
		}
		return index;
	}
}
