package Practice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession {
	private String number;// 课程编号
	private String department;// 课程名字
	private Date date;
	private Date endtDate;
	private static int count = 0;// 课程数量
	/** 注册：List某一门课的学生 */
	public static List<Student> allStudentName = new ArrayList<Student>();

	public static List<Student> getLes() {
		return allStudentName;
	}

	public CourseSession(String number, String department) {
		this(number, department, null);
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);
		date = c.getTime();
	}

	/** 添加一个新的构造函数，这次接受三个参数，课程名称，课程编号，开课日期。这里日期使用Date类型 */
	public CourseSession(String number, String department, Date startDate) {
		this.number = number;
		this.department = department;
		this.date = startDate;
		count++;
	}

	/** 接受课程编号 */
	public String getNumber() {
		return number;
	}

	public void setDepartment(String department) {
		incrementCount();
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	/** 添加一个新方法getNumberOfStudents()，返回学习这门课程学生的数量。 */
	public int getNumberOfStudents() {
		return allStudentName.size();
	}

	/** 添加一个新方法enroll(Student student),用来给这门课注册学生。 */
	public void enroll(Student student) {
		allStudentName.add(student);
	}

	// /**
	// 添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。
	// */
	// public List<Student> getAllStudents(Student stu) {
	// return allStudentName;
	// }

	/** 添加新方法get(int index), 返回第index个注册的学生。 */
	public Student get(int index) {
		return allStudentName.get(index);
	}

	/** 获得开课时间 */
	public Date getStartDate() {

		return date;
	}

	/** 课程结束时间 */
	public Date getEndDate() {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, 6);
		Date endDate = c.getTime();
		return endDate;
	}

	public static int incrementCount() {
		return count;
	}

	public static CourseSession create(String number, String department) {
		CourseSession course = new CourseSession(number, department);
		CourseReport report = new CourseReport();
		report.add(course);
		return course;
	}

	public static CourseSession create(String number, String department, Date date) {
		CourseSession course = new CourseSession(number, department);
		CourseReport report = new CourseReport();
		report.add(course);
		return course;
	}
}
