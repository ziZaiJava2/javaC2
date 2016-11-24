package com.zizaitianyuan.javac2.lesson06.practice;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class DateUtil {
       private DateUtil(){
    	   
       }
       private String creatDate(int year, int month, int day){
    	   Date date = new Date();
    	   Calendar c = Calendar.getInstance();
    	   c.set(year, month, day);
    	   SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    	   date = c.getTime();
    	   String time = sdf.format(date);
		   return time;
    	   
       }
}
