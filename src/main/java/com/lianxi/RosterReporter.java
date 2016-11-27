package com.lianxi;
//����µ��࣬���������������һ�ſγ̵ı���ġ�

public class RosterReporter {
	// ����µ�����һ�����캯��������CourseSession����
	private CourseSession lesson1;

	public RosterReporter(CourseSession lesson) {
		this.lesson1 = lesson;
	}

	// ����µ�����һ������getReport()������һ���ַ������ַ����Ƕ��ڹ��캯������Ŀγ̵�����:
	public String getReport(CourseSession lesson) {

		// �ַ�����һ�У��γ����ƣ���ţ��μ�ѧϰѧ���������������� ~ ��������
		String report = "�γ�����:" + lesson.getDepartment() + "\t" + "���:" + lesson.getNumber() + "\t" + "�μ�ѧϰѧ������:"
				+ lesson.getNumberOfStudents() + "\t" + "��������~��������:" + lesson.getStartDate() + "~" + lesson.getEndDate()
				+ "\t" + "\n";

		// ����ÿһ���г�һ��ѧ��������
		for (int i = 0; i < this.lesson1.getNumberOfStudents(); i++) {// ��0��������
			report += lesson1.get(i).getName() + "\n";
			;// ȡ�õ�i���˵�����
		}
		return report;

	}

	// ����һ���γ̣�ע��4��ѧ����Ȼ��ͨ������µ����ӡһ�����������
	public void main(String[] args) {
		CourseSession lesson = new CourseSession("102", "English");
		Student firstStu = new Student("һ����");
		Student secondStu = new Student("������");
		Student thirdStu = new Student("������");
		Student fourSth = new Student("�ĸ���");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		lesson.enroll(thirdStu);
		lesson.enroll(fourSth);
		RosterReporter report = new RosterReporter(lesson);
		System.out.println(report.getReport(lesson));
	}
}
