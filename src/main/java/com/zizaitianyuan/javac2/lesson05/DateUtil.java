package com.zizaitianyuan.javac2.lesson05;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	 
	private DateUtil(){};
	
	public static Date creatDate(int year, int month, int day){
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}
}
