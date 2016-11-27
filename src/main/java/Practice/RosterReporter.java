package Practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RosterReporter {

	private CourseSession c;

	public RosterReporter(CourseSession c) {
		this.c = c;
	}

	public String getReport() {
		DateFormat df = new SimpleDateFormat("yyyy年MM月d日");
		/**
		 * 字符串第一行，课程名称，编号，参加学习学生总数，开课日期 ~ 结束日期 接着每一行列出一个学生的名字
		 */
		String studentName = "";
		for (int i = 0; i < CourseSession.allStudentName.size(); i++) {
			studentName = studentName + CourseSession.allStudentName.get(i).getName() + "\n";
		}
		String data = "课程名称:" + c.getDepartment() + "    编号:" + c.getNumber() + "    参加学习学生总数:"
				+ c.getNumberOfStudents() + "   开课日期:" + df.format(c.getStartDate()) + " " + "~" + " 结束日期:"
				+ df.format(c.getEndDate()) + "\n" + studentName;
		return data;
	}

}
