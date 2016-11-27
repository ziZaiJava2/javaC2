package com.lianxi;

public class RosterReporter {
	
//这个新的类有一个构造函数，接受CourseSession对象。
	private CourseSession lesson1;

	public RosterReporter(CourseSession lesson) {
		this.lesson1 = lesson;
	}

//	这个新的类有一个方法getReport()，返回一个字符串。字符串是对于构造函数传入的课程的描述:
	public String getReport(CourseSession lesson) {

//		字符串第一行，课程名称，编号，参加学习学生总数，开课日期 ~ 结束日期
		String report = "课程:" + lesson.getDepartment() + "\t"
		+ "编号:" + lesson.getNumber() + "\t" 
		+ "参加学习学生总数:" + lesson.getNumberOfStudents() + "\t"
		+ "开课日期 ~ 结束日期:" + lesson.getStartDate() + "~" + lesson.getEndDate() + "\t" 
		+ "\n";

//		开课日期 ~ 结束日期
		for (int i = 0; i < this.lesson1.getNumberOfStudents(); i++) {// ��0��������
			report += lesson1.get(i).getName() + "\n";
			;
		}
		return report;

	}

//	构造一个课程，注册4名学生，然后通过这个新的类打印一个报告出来。
	public void main(String[] args) {
		CourseSession lesson = new CourseSession("102", "English");
		Student firstStu = new Student("一个人");
		Student secondStu = new Student("两个人");
		Student thirdStu = new Student("三个人");
		Student fourSth = new Student("四个人");
		lesson.enroll(firstStu);
		lesson.enroll(secondStu);
		lesson.enroll(thirdStu);
		lesson.enroll(fourSth);
		RosterReporter report = new RosterReporter(lesson);
		System.out.println(report.getReport(lesson));
	}
}
