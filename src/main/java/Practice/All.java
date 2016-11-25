package Practice;

public class All {

	public static void main(String[] args) {
		Student student = new Student("Leon");
		CourseSession course = new CourseSession("102", "English");
		System.out.println(student.getName() + "  " + course.getNumber() + "  " + course.getDepartment());
	}

}
