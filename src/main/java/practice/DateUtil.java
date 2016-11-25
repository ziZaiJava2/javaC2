package practice;

import java.util.Date;

/**
 * 日期工具类
 * 
 * @author Administrator
 *
 */
public class DateUtil {
	private DateUtil() {
	}

	@SuppressWarnings("deprecation")
	public Date createDate(int year, int month, int day) {
		return new Date(year, month, day);
	}
}
