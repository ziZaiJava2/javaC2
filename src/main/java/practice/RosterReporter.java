package practice;

/**
 * ���浥�࣬���ɿγ���Ϣ
 * 
 * @author Administrator
 *
 */
public class RosterReporter {
	CourseSession courseSession;

	public RosterReporter(CourseSession courseSession) {
		this.courseSession = courseSession;
	}

	// ���ر�����Ϣ
	public String getReport() throws Exception {
		String des = courseSession.getDepartment() + " " + courseSession.getNumber() + " "
				+ courseSession.getNumberOfStudents() + " " + courseSession.formated1() + "~"
				+ courseSession.formated2() + "\n";
		for (int i = 0; i < courseSession.getNumberOfStudents(); i++) {
			des += courseSession.getIndex(i) + "\n";
		}
		return des;
	}

}
