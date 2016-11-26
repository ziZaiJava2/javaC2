package com.zizaitianyuan.javac2.lianxi1124;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private DateUtil() {

	}

	private String creatDate(int year, int month, int day) {
		Date date = new Date();
		Calendar time = Calendar.getInstance();
		int year1 = time.get(Calendar.YEAR);// 获取年份
		int month1 = time.get(Calendar.MONTH);// 获取月份
		int day1 = time.get(Calendar.DATE);// 获取日
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义时间输出格式
		String time1 = dateFormat.format(date);//转化格式输出
		return time1;

	}

}
