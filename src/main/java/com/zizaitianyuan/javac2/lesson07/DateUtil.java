package com.zizaitianyuan.javac2.lesson07;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	private DateUtil() {
		// DateUtil du = new DateUtil();
	}

	public Date createDate(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day); // Date该方法已过时
		return cal.getTime(); // 调用该方法，将Calendar类型cal转化为Date类型
	}

	// 距离天数
	public String getDays(CourseSession course) {
		long time1 = course.getStartDate().getTime();
		long time2 = course.getEndDate().getTime();
		long time = CourseSession.getDate().getTime(); // System.currentTimeMillis();//与上面的相同,获取系统当前时间毫秒数
		String a = course.getDepartment() + "课程：" + "\n开始日期距离现在还有" + (time1 - time) + "天" + "\n结束日期距离现在还有"
				+ (time2 - time) + "天";
		return a;
	}

	public Date getFirstDate(Date date1, Date date2, Date date3) {
		Date firstDate = date1;
		if (date2.before(firstDate)) {
			firstDate = date2;
		} else if (date3.before(firstDate)) {
			firstDate = date3;
		}
		return firstDate;
	}
}
