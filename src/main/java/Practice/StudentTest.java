package Practice;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
	@Test
	public void testCreateStudent() {
	    Student leon = new Student("Leon");
	    Assert.assertEquals("Leon", leon.getName());
	}
	
	@Test
	public void testCreateLesson() {
		CourseSession session = new CourseSession("102","English");
		Assert.assertEquals("102", session.getNumber());
		Assert.assertEquals("English", session.getDepartment());
	}
	
	@Test
	public void testGetNumberOfStudents(){
		CourseSession lesson = new CourseSession("English", null);
		
	}
}

