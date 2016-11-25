package com.lianxi;
//����µ��࣬���������������һ�ſγ̵ı���ġ�

public class RosterReporter {
//����µ�����һ�����캯��������CourseSession����
	public RosterReporter(CourseSession lesson){
		
	}

//����µ�����һ������getReport()������һ���ַ������ַ����Ƕ��ڹ��캯������Ŀγ̵�����:
	public String getReport(CourseSession lesson){
		
//�ַ�����һ�У��γ����ƣ���ţ��μ�ѧϰѧ���������������� ~ ��������
		String report1 ="�γ�����:" + lesson.getDepartment() + "\t"
				+ "���:" + lesson.getNumber() + "\t"
				+ "�μ�ѧϰѧ������:" + lesson.getNumberOfStudents() +"\t"
				+ "��������~��������:" + lesson.getStartDate() + "~" + lesson.getEndDate() + "\t"
				+ "\n";
		
//����ÿһ���г�һ��ѧ��������
			String[] report2 = {};
			for(int i=0;i<lesson.getNumberOfStudents();i++){//��0��������
				report2[i] = lesson.get(i).getName();//ȡ�õ�i���˵�����
			}
			String report = report1 + report2;//�����ַ������
			return report;
		
	}
	
//����һ���γ̣�ע��4��ѧ����Ȼ��ͨ������µ����ӡһ�����������
	public void main(String[] args){
		CourseSession lesson = new CourseSession("102","English");
		Student firstStu = new Student("һ����");
		Student secondStu = new Student("������");
		Student thirdStu = new Student("������");
		Student fourSth = new Student("�ĸ���");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		lesson.enroll(thirdStu);
		lesson.enroll(fourSth);
		System.out.println(lesson.getReport);//��֪��Ϊʲô�򲻳�,��������Ϊ��֪��ʲô�н��ն���
	}
}
