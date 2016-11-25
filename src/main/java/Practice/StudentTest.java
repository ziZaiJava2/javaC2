package Practice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
	@Test
	public void testCreateStudent() {
	    Student leon = new Student();
	    leon.setName("Leon");
	    Assert.assertEquals("Leon", leon.getName());
	}
	
	@Test
	public void testCreateLesson() {
		CourseSession session = new CourseSession("102","English");
		Assert.assertEquals("102", session.getNumber());
		Assert.assertEquals("English", session.getDepartment());
	}
	
	//新的测试case，创建一个English的课程，assert默认getNumberOfStudents()返回值为0
	@Test
	public void testGetNumberOfStudents(){
		CourseSession lesson = new CourseSession();
		lesson.setDepartment("English");	
		Assert.assertEquals( lesson.getNumberOfStudents(), 0);
	}
	
	//新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册两名学生，assert方法getNumberOfStudents()返回2.
	@Test
	public void testGetNumberOfStudents2(){
		CourseSession lesson = new CourseSession();
		lesson.setDepartment("English");
		Student namee = new Student();
	    namee.setName("xiaohong");
	    namee.setName("xiaoming");
	    lesson.enroll();
		Assert.assertEquals( lesson.getNumberOfStudents(), 2);
	}
	
	//新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册两名学生，然后通过getAllStudents()取得所有学生，assert返回的学生的对象就是你注册的两个。
	@Test
	public void testGetNumberOfStudents3(){
		CourseSession lesson = new CourseSession();
		lesson.setDepartment("English");
		Student namee = new Student();
	    namee.setName("xiaohong");
	    namee.setName("xiaoming");
	    List<Student> stu = new ArrayList<Student>();
	    stu.add(namee.setName("xiaohong"));
	    stu.add(namee.setName("xiaoming"));		
		Assert.assertEquals(stu<Student>() ,lesson.getAllStudents() );
	}
	
	//新的测试case，创建一个English的课程，给这门课程使用enroll(student)方法注册3名学生，通过get(2)获取学生，assert和你enroll的第三个学生是不是同一个。
	@Test
	public void testGetNumberOfStudents4(){
		
	}
	
	//添加测试方法，需要测试的几个点是：
//	使用两个参数的构造函数生成的课程对象，开始日期getStartDate()是当前月的下一个月的第一天
//	使用三个参数的构造函数生成的课程对象，开始日期getStartDate()是传入的日期，结束日期getEndDate()是传入日期六个月之后
	public void testDate(){
		
	}
}

