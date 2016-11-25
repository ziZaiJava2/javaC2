package Practice;

import java.text.DateFormat;
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
}
