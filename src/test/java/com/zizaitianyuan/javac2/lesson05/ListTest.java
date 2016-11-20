package com.zizaitianyuan.javac2.lesson05;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

	private ArrayList<String> list;
	
	/*
	 * before方法会在每个case运行之前被调用
	 * 
	 * 我们一般用他来做在case执行前做初始化的工作
	 * 
	 * 这里我们每次执行case之前都生成一个新的ArrayList
	 * 这样每次测试就不会相互影响
	 */
	@Before
	public void before() {
		list = new ArrayList<String>();
	}
	
	/*
	 * 对应的有一个after，这个在每次case执行完之后执行
	 * 
	 */
	@After
	public void after() {
		list = null;
	}
	
	/*
	 * list中可以加入null
	 */
	@Test
	public void addNull() {
		list.add(null);
		
		Assert.assertEquals("list的size应该是1，因为添加了一个null", 1, list.size());
		Assert.assertNull("第0个元素应该为null", list.get(0));
	}
	
	/*
	 * 一个元素可以重复的添加到list中
	 */
	@Test
	public void duplicateAdd() {
		String str = "str";
		
		// 我们把同一个字符串添加两次
		list.add(str);
		list.add(str);
		
		Assert.assertEquals("list的size应该是2", 2, list.size());
		
		Assert.assertSame("list的第一个元素和第二个元素应该是同一个元素", list.get(0), list.get(1));
	}
	
	/*
	 * list中的元素是有序的
	 */
	@Test
	public void orderList() {
		list.add("str1");
		list.add("str2");
		list.add("str3");
		
		Assert.assertEquals("str1", list.get(0));
		Assert.assertEquals("str2", list.get(1));
		Assert.assertEquals("str3", list.get(2));
	}
}
