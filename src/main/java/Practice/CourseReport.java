package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseReport {

	public static List<CourseSession> lessons = new ArrayList<CourseSession>();

	public void add(CourseSession course) {

		lessons.add(course);
	}

	/** 给课程名字进行排序 */
	public String text() {
		Collections.sort(lessons, new Comparator<CourseSession>() {

			@Override
			public int compare(CourseSession o1, CourseSession o2) {

				return o1.getNumber().compareTo(o2.getNumber());
			}
		});
		String lessonName = "课程名单： " + "\n";
		for (CourseSession name : lessons) {
			lessonName = lessonName + name.getDepartment() + "\n";
		}
		return lessonName;
	}
}
