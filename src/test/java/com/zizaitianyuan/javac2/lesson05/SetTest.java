package com.zizaitianyuan.javac2.lesson05;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Set是一个无序，不能包含重复元素的容器
 * 
 * 我们可以对比List，list是一个有序的可以包含重复元素的容器
 * 
 * 
 * 同样的，我们最常用的的是HashSet，同样是采用hash算法实现，
 * 
 * 有判断一个元素是否在set中存在的时间复杂度是o(1)；
 * 
 * 
 * Set最常使用的用法是将一组元素插入到Set中，之后可以在常量时间
 * 内判断某个元素是否存在于这组元素中
 * 
 */
public class SetTest {
	
	private Set<String> set;
	
	@Before
	public void before() {
		set = new HashSet<String>();
	}
	
	
	@Test
	public void noDuplication() {
		
		set.add("str");
		set.add("str");
		
		Assert.assertEquals("重复的添加一个元素，set的长度只会增加1", 1, set.size());
	}

}
