package com.zizaitianyuan.javac2.lesson06.practice;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUnitlTest {

	@Test
	public void getClapDateTest() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(2016, 10, 25);
		date = c.getTime();
		assertEquals(-2, DateUtil.getClapOfNow(date));
		c.set(2016, 10, 29);
		date = c.getTime();
		assertEquals(2, DateUtil.getClapOfNow(date));
	}

	@Test
	public void getEalierDateTest() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		c1.set(2016, 10, 1);
		c1.set(2016, 10, 2);
		c1.set(2016, 10, 3);
		Date date1 = c1.getTime();
		Date date2 = c2.getTime();
		Date date3 = c3.getTime();
		assertEquals(date1, DateUtil.getEarlierDate(date1, date2, date3));

	}
}
