package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class IsFullTest {
//	���һ��case������һ��ѧ�����󣬵�������isFullTime()������assertӦ�÷���false����Ϊ�´�����ѧ����û����ѧ�֣�
//	��Ϊ����12��ѧ�ֵ�ѧ��������ȫ����ѧ����
	@Test
	public void test() {
		Student firstStu = new Student("һ����");
		Assert.assertEquals(false, firstStu.isFullTime());
	}

}
