package com.lianxi;

import java.util.Calendar;


public class DateUtil {
	private DateUtil() {
	}

	public void createDate(int year, int month, int day) {
		Calendar days = Calendar.getInstance();
		days.set(year, month, day);
	}

}
