package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 课程类，包含课程的属性和注册注册该课程的学生
 * @author Administrator
 *
 */
public class CourseSession {
	String department;
	String number;
	private int studentCount = 0;
	List<Student> stu = new ArrayList<>();
	private Date openCourse;
	Date endCourse;
	private static String str = "yyyy-MM-dd";
	private static int count;
	//创造CourseSession对象
	public static CourseSession create(String department, String number) {
		return new CourseSession(department, number);
	}

	public static CourseSession create(String department, String number, Date openCourse) {
		return new CourseSession(department, number, openCourse);
	}
	//返回课程总数
	public int getCount() {
		return count;
	}
	
	private CourseSession(String department, String number) {
		this(department, number, null);
	}

	private CourseSession(String department, String number, Date openCourse) {
		this.department = department;
		this.number = number;
		this.openCourse = openCourse;
		incrementCount();
	}

	public String getDepartment() {
		return department;
	}
	//返回课程名称
	public String getNumber() {
		return number;
	}
	//学生注册
	public void enroll(Student student) {
		stu.add(student);
		studentCount++;

	}
	//返回学生总数
	public int getNumberOfStudents() {
		return studentCount;
	}
	//返回一个学生对象
	public Student getIndex(int index) {
		return stu.get(index);
	}
	//返回开课日期
	public Date getStartDate() throws Exception {
		DateFormat df = DateFormat.getDateInstance();
		String start = df.format(openCourse);
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		Date startDate = sdf.parse(start);
		return startDate;
	}
	//返回结课日期
	@SuppressWarnings("deprecation")
	public Date getEndDate() throws Exception {
		openCourse.setMonth(openCourse.getMonth() + 6);
		DateFormat df1 = DateFormat.getDateInstance();
		String end = df1.format(openCourse);
		SimpleDateFormat sdf = new SimpleDateFormat(str);
		Date endDate = sdf.parse(end);
		return endDate;
	}
	//计算课程数量方法
	private static void incrementCount() {
		count++;
	}
}
