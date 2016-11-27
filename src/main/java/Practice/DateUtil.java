package Practice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	private DateUtil() {

	};

	public Date createDate(int year, int month, int day) {
		Date date = new Date();
		GregorianCalendar time = new GregorianCalendar();
		time.set(Calendar.YEAR,year);//设置年
		time.set(Calendar.MONTH, month+1);//这里0是1月..以此向后推
		time.set(Calendar.DAY_OF_MONTH, day);//设置天
		time.set(Calendar.HOUR_OF_DAY,00);//设置小时
		time.set(Calendar.MINUTE, 00);//设置分
		time.set(Calendar.SECOND, 00);//设置秒
//		time.set(Calendar.MILLISECOND,200);//设置毫秒
		
		date = time.getTime();
		return date;

	}
	
	/**一个方法返回一个Date距离现在有多少天，比当前时间晚用正数，比当前时间早用负数
	 * @throws ParseException */
	public long leavingDay() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dstr = df.format(CourseSession.getStartDate());
		java.util.Date date= df.parse(dstr);
		
		long s1 = date.getTime();
		long s2 = System.currentTimeMillis();//当前毫秒
		long day = (s2-s1)/1000/60/60/24;
		return day;
	}
	 public Date DateUtil(Date date1 ,Date date2 ,Date ...args ){
		 
		 Date firstDay = date1;
		 if(date1.compareTo(date2)>0){
			 firstDay =date2;
		 }
		 return firstDay;
	 }
}
