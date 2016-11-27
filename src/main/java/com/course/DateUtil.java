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
}
