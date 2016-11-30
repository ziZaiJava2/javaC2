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
	/*
	 * 一个方法返回一个Date距离现在有多少天，比当前时间晚用正数，比当前时间早用负数
                  一个方法，接受多个Date参数，返回最早的那个日期
	 */
	
}
