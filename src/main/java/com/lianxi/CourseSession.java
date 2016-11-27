package com.lianxi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//������һ���γ̵���(CourseSession)

public class CourseSession {
	private String number;
	private String course;
	private List<Student> line = new ArrayList<Student>();
	private Date open;// ���ص�ʱ��Ҫ��Ҫ�����ｨopen��
	// ���һ����̬�ֶ�count��ͳ���ܹ��еĿγ�����
	private static int count;

	// ��һ�����캯�������ܿγ̱��(String)���Ϳγ�����(String)����Ϊ���֡�

	public CourseSession(String num, String course) {
		this(num, course, new GregorianCalendar(Calendar.YEAR, Calendar.MONTH + 2, 1).getTime());
	}
	// ���һ���µĹ��캯������ν��������������γ����ƣ��γ̱�ţ��������ڡ���������ʹ��Date���͡�
	// ԭ���Ĺ��캯����ת������������µĹ��캯�������������ǵ�ǰ�����¸��µĵ�һ�졣

	public CourseSession(String num, String course, Date date) {
		this.number = num;
		this.course = course;
		this.open = date;
		count++;
	}

	// �ṩһ��getDepartment()�ķ�������ȡ�γ����ơ�
	public String getDepartment() {
		return this.course;
	}

	// �ṩһ��getNumber()�ķ�������ȡ�γ̱��
	public String getNumber() {
		return this.number;
	}

	// ����һ���Լ��Ĵ��룬�����ͨ��main������������֤caseͨ��
	// ����һ��ѧ��ʵ�����������ֽ���Leon������ͨ��getName()��ȡ�������
	// ����һ�ſγ̵�ʵ�����γ�������English,�����102������ͨ����Ӧ������ȡ�γ����ƺͱ��
	// ����������һ������������Test���࣬��ӵ�Ԫ����
	public void main(String[] args) {
		Student stu = new Student("Leon");
		CourseSession lesson = new CourseSession("102", "English");
		System.out.println("ѧ��������" + stu.getName() + " �γ̺ţ�" + lesson.getNumber() + " �γ̣�" + lesson.getDepartment());
	}// ����StudentTest֮����ܲ������ˣ�û��֮ǰ��runѡ�

	// ���һ���·���getNumberOfStudents()������ѧϰ���ſγ�ѧ����������
	public int getNumberOfStudents() {
		return this.line.size();
	}

	// ���һ���·���enroll(Student student),���������ſ�ע��ѧ����
	public void enroll(Student student) {
		line.add(student);
	}

	// ��ӷ���getAllStudents(),�����ķ���ֵ��List<Student>.���ذ�������ͨ��enroll()����ע���ѧ����List��
	// public List<Student> getAllStudents(){
	// return this.line;
	// }

	// ����·���get(int index), ���ص�index��ע���ѧ����
	public Student get(int index) {
		return this.line.get(index - 1);
	}

	// ��ӷ���getStartDate()������Date���ͣ�Ϊ��������
	public Date getStartDate() {
		return this.open;
	}

	// ��ӷ���getEndDate()������Date���ͣ�Ϊ��������������֮������ڡ�
	public Date getEndDate() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getStartDate());
		cal.add(Calendar.MONTH, +6);
		Date day = cal.getTime();
		return day;
	}

	// ���һ��case�����������γ̶���Ȼ��assert����CurseSession.count�Ƿ����3
	// ����һ����̬����getCount(),����ȡ�ܵĿγ�����
	public static int getCount() {
		return count;
	}

	// ���һ��case�����������γ̶���Ȼ��assert����CurseSession.getCount()�Ƿ����3
	// ���ʱ�򽫾�̬�ֶ�count����Ϊprivate��ͬʱɾ�������case��
}
