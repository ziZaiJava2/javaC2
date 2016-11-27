package Practice;

public class All {

	public static void main(String[] args) {
		CourseSession c = new CourseSession("001", "English");
		Student stu1 = new Student("sf1");
		Student stu2 = new Student("f2");
		Student stu3 = new Student("fs3");
		Student stu4 = new Student("s4");
		c.enroll(stu1);
		c.enroll(stu2);
		c.enroll(stu3);
		c.enroll(stu4);
		RosterReporter rep = new RosterReporter(c);
		System.out.println(rep.getReport());

		CourseSession.create("001", "English");
		CourseSession.create("005", "Chinese");
		CourseSession.create("003", "Japan");
		CourseSession.create("004", "France");

		System.out.println(new CourseReport().text());
	}
}