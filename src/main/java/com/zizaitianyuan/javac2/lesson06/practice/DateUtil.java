package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class DateUtil {
	private DateUtil() {

	}

	public static Date creatDate(int year, int month, int day) {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		date = c.getTime();
		return date;

	}

	/**
	 * 返回一个日期到现在有多少天，比当前时间完是正数，比当前时间早是负数
	 * 
	 * @return
	 */
	public static int getClapOfNow(Date date) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Date nowDate = new Date();
		if (!nowDate.before(date)) {
			c1.setTime(date);
			int setDay = c1.get(Calendar.DAY_OF_YEAR);
			int nowDay = c2.get(Calendar.DAY_OF_YEAR);
			return setDay - nowDay;// 返回负数
		} else {
			c1.setTime(date);
			int setDay = c1.get(Calendar.DAY_OF_YEAR);
			int nowDay = c2.get(Calendar.DAY_OF_YEAR);
			return setDay - nowDay;// 返回正数
		}
	}

	/**
	 * 输入三个Date参数
	 * 
	 * @param date1
	 * @param date2
	 * @param date3
	 * @return 返回一个三个参数中日期最早的
	 */
	public static Date getEarlierDate(Date date1, Date date2, Date date3, Date ...args) {
		Date tempDate;
		if (!date1.before(date2)) {
			tempDate = date1;
			date1 = date2;
			date2 = tempDate;
		}
		if (!date2.before(date3)) {
			tempDate = date2;
			date2 = date3;
			date3 = tempDate;
		}

		if (date1.before(date2)) {
			return date1;
		} else {
			return date2;
		}

	}
}