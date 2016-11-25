package Practice;

public class All {

	public static void main(String[] args) {
		CourseSession c = new CourseSession("001", "English");
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();

		stu1.setName("sf1");
		stu2.setName("f2");
		stu3.setName("fs3");
		stu4.setName("s4");
		c.enroll(stu1);
		c.enroll(stu2);
		c.enroll(stu3);
		c.enroll(stu4);
		RosterReporter rep = new RosterReporter(c);
		System.out.println(rep.getReport());
	}

}
