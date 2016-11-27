package com.zizaitianyuan.javac2.lesson05;

public class RosterReporter {
	
	private String report;

	public RosterReporter(CourseSession temp){
		String a = "课程名称" + temp.getDepartment() + "," 
			+ "课程编号" + temp.getNumber() + ","
			+ "学生人数：" + temp.getNumberOfStudents() + ","
			+ "开课时间：" + temp.getStartDate()+ ","
			+ "结束时间：" + temp.getEndDate();
//		List<Student> stus = new ArrayList<Student>();
		
		for(int i = 0; i < temp.course.size(); i++) {
			a += "\n" + temp.course.get(i).getName() ;
		};
		this.report = a ;
	}
	
	public String getReport(){	
		return this.report;
	}
}
