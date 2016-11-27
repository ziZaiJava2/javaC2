package com.zizaitianyuan.javac2.lianxi1124;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
