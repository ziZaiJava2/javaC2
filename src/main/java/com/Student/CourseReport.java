package practice;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 课程保单类，按顺序打印课程
 * 
 * @author Administrator
 *
 */
public class CourseReport {
	SortedSet<CourseSession> courseList = new TreeSet<CourseSession>();

	public void add(CourseSession course) {
		courseList.add(course);
	}

	public String text() {
		Iterator<CourseSession> iter = courseList.iterator();
		int i = 1;
		String text = null;
		while (iter.hasNext()) {
			text += "" + (i++) + "." + iter.next();
		}
		return text;
	}
}
