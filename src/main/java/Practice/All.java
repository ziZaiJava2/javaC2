package Practice;

public class All {

	public static void main(String[] args) {
		CourseSession cour = new CourseSession();
		cour.setDepartment("English");
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		stu1.setName("1");
		stu2.setName("2");
		stu3.setName("3");
		stu4.setName("4");
		RosterReporter rep = new RosterReporter();
		System.out.println(rep.getReport());
	}

}
