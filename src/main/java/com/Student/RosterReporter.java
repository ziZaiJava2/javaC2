package practice;
/**
 * 报告单类，生成课程信息
 * @author Administrator
 *
 */
public class RosterReporter {
	CourseSession courseSession;

	public RosterReporter(CourseSession courseSession) {
		this.courseSession = courseSession;
	}
	//返回报单信息
	public String getReport() throws Exception {
		String des = courseSession.getDepartment() + " " + courseSession.getNumber() + " "
				+ courseSession.getNumberOfStudents() + " " + courseSession.getStartDate() + "~"
				+ courseSession.getEndDate() + "\n";
		for (int i = 0; i < courseSession.getNumberOfStudents(); i++) {
			des += courseSession.getIndex(i) + "\n";
		}
		return des;
	}
}
