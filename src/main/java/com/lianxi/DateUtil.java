package com.lianxi;

import java.util.Calendar;

//���Ŵ���һ��������DateUtil
//��������һ���޲εĹ��캯���������η�����Ϊprivate��Ȼ�����Կ��Ƿ��ܴ�������ʵ����
//���һ��createDate(int year, int month, int day)�ķ�������������һ��Date����year�꣬month�£�day�գ���ʱ������롣

public class DateUtil {
	private DateUtil() {
	}

	public void createDate(int year, int month, int day) {
		Calendar days = Calendar.getInstance();
		days.set(year, month, day);
	}

}
