package Practice;

public class RosterReporter {
	private Student session;

	public RosterReporter() {
	}

	public String getReport() {
		CourseSession c = new CourseSession();
		String data = (String) (c.getDepartment() + c.getNumber() + c.getNumberOfStudents() + c.getStartDate() + "~"
				+ c.getEndDate() + "\n");
		return data;
	}

}
