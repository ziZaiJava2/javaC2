package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class DateUtil {
	private DateUtil() {

	}

	private static Date creatDate(int year, int month, int day) {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		date = c.getTime();
		return date;

	}
}
