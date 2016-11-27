package com.course;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ���ڹ�����
 * 
 * @author Administrator
 *
 */
public class DateUtil {
	private DateUtil() {
	}

	public static Date createDate(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day);
		return cal.getTime();
	}

	public static int dayCount(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		long time1 = cal.getTimeInMillis();
		cal.setTime(new Date());
		long time2 = cal.getTimeInMillis();
		int between_days = (int) ((time1 - time2) / (1000 * 3600 * 24));
		return between_days;
	}

	public static Date minDate(Date... arg) {
		Date min = arg[0];
		for (int i = 1; i < arg.length; i++) {
			if (arg[i].before(min)) {
				min = arg[i];
			}
		}
		return min;
	}
}
