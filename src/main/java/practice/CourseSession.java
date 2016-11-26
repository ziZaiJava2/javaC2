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
	private String department;
	private String number;
	private List<Student> stu = new ArrayList<>();
	private Date openCourseDate;
	private static String str = "yyyy-MM-dd";
	private int count;

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
		this(department, number, new GregorianCalendar(Calendar.YEAR, Calendar.MONTH + 2, 1).getTime());
	}

	private CourseSession(String department, String number, Date openCourse) {
		this.department = department;
		this.number = number;
		this.openCourseDate = openCourse;
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

	}

	// ����ѧ������
	public int getNumberOfStudents() {
		return stu.size();
	}

	// ����һ��ѧ������
	public Student getIndex(int index) {
		return stu.get(index);
	}

	// ���ؿ�������
	private Date getStartDate() throws Exception {
		return openCourseDate;
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
	private void incrementCount() {
		count++;
	}

}
