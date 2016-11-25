package com.lianxi;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
//���һ�����Է�������ѧ��������һ��ѧ��ʵ�������ֽ���Leon,Ȼ��assert����getName()�������ص�������Leon��
public class StudentTest {

	@Test
	public void testCreateStudent() {
	    Student leon = new Student("Leon");
	    Assert.assertEquals("Leon", leon.getName());
	}

}
//��me��ʦ���Ҳ�֪�����Է�����ʲô��˼���͸���ճ���ˣ����һ�ͷ������Ƶ��