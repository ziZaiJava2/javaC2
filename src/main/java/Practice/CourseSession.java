package Practice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

public class CourseSession {
	private String number;
	private String department;
	private Date startDate;
	private Date endtDate;
	static int count = 0;
	/** 某一门课的学生 */
	public static List<Student> les = new ArrayList<Student>();

	public static List<Student> getLes() {
		return les;
	}


	

	public CourseSession(String number, String department) {
		this.number = number;
		this.department = department;
	}

	/** 添加一个新的构造函数，这次接受三个参数，课程名称，课程编号，开课日期。这里日期使用Date类型 */
	public CourseSession(String number, String department, Date startDate) {
		this.number = number;
		this.department = department;
		this.startDate = getStartDate();
	}
	
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
		return les.size();
	}

	/** 添加一个新方法enroll(Student student),用来给这门课注册学生。 */
	public void enroll(Student student) {
		les.add(student);
	}

	/** 添加方法getAllStudents(),方法的返回值是List<Student>.返回包含所有通过enroll()方法注册的学生的List。 */
	public List<Student> getAllStudents(Student stu) {
		return les;
	}

	/** 添加新方法get(int index), 返回第index个注册的学生。 */
	public Student get(int index) {
		return les.get(index - 1);
	}


	/** 原来的构造函数会转过来调用这个新的构造函数，开课日期是当前日期下个月的第一天。 */
	public Date getStartDate() {

		Calendar c = Calendar.getInstance();
		// c.set(Calendar.DATE, 1);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
		c.set(Calendar.DAY_OF_MONTH, 1);

		return c.getTime();
	}

	/** 添加方法getEndDate()，返回Date类型，为开课日期六个月之后的日期。 */
	public Date getEndDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 7);
		c.set(Calendar.DAY_OF_MONTH, 1);
		this.endtDate = c.getTime();
		return this.endtDate;
	}
	

	private static void incrementCount(){
		count++;
	}
}
