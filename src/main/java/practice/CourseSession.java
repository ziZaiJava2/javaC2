package practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * �γ��࣬�����γ̵����Ժ�ע��ע��ÿγ̵�ѧ��
 * 
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

	// ����CourseSession����
	public static CourseSession create(String department, String number) {
		return new CourseSession(department, number);
	}

	public static CourseSession create(String department, String number, Date openCourse) {
		return new CourseSession(department, number, openCourse);
	}

	// ���ؿγ�����
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

	// ���ؿγ�����
	public String getNumber() {
		return number;
	}

	// ѧ��ע��
	public void enroll(Student student) {
		stu.add(student);
		studentCount++;

	}

	// ����ѧ������
	public int getNumberOfStudents() {
		return studentCount;
	}

	// ����һ��ѧ������
	public Student getIndex(int index) {
		return stu.get(index);
	}

	// ���ؿ�������
	private Date getStartDate() throws Exception {
		return openCourse;
	}

	// ���ؽ������
	private Date getEndDate() throws Exception {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStartDate());
		cal.add(Calendar.MONTH, +6);
		Date date = cal.getTime();
		return date;
	}

	public String formated1() throws Exception {
		SimpleDateFormat sim = new SimpleDateFormat(str);
		return sim.format(getStartDate());
	}

	public String formated2() throws Exception {
		SimpleDateFormat sim = new SimpleDateFormat(str);
		String a = sim.format(getEndDate());
		return a;
	}

	// ����γ���������
	private static void incrementCount() {
		count++;
	}
}
