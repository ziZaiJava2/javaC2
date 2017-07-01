package com.zizaitianyuan.luozheng2;

import java.util.Date;

public class DateUtil {
	private DateUtil() {

	}

	public static Date createDate(int year, int month, int day) {
		Date d = new Date(year, month, day, 0, 0);
		return d;
	}

	public int FromNow() {

		return 0;

	}
}
