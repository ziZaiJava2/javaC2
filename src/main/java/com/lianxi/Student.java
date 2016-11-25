package com.lianxi;

import java.util.Scanner;

//����һ��ѧ�����ࣨStudent����Ҫ��
//��һ�����캯�����������֣�String����Ϊ����
//�����и�getName()�ķ���������ȡ��ѧ�������֡�

public class Student {
	
	private String name;
	
	public Student(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
//	ѧ����Ϊȫ���ƺͷ�ȫ���յġ�ѧ������12��ѧ�־���ȫ���Ƶ�ѧ����������Ƿ�ȫ���Ƶ�
//	���һ���µķ���isFullTime()��Student�࣬�÷�������һ������ֵ�������ж�ѧ���Ƿ���ȫ���Ƶ�ѧ���������ȸ�������Ĭ��ֵfalse��
	public boolean isFullTime(){
		return ;
	}

//	�������һ��getCredits()��������ȡѧ����ѧ�֣�����һ��int����
//	���һ��case������һ��ѧ��������Ϊ��û���޿γ̣�assert����getCredits()�����ķ���ֵ��0
	public int getCredits(){
		return 
	}
//	���һ������addCredits(int credits),������ѧ�����ѧ��
//	���һ��case��������ô��������·�����
	public void addCredits(int credits){
		
	}
	
//	���ˣ������Ѿ���ѧ���ˣ����Իع�ͷ��ʵ��isFullTime()
//
//	���һ��case����ѧ�����12��ѧ�֣�Ȼ��assert����isFullTime()��������true
//	���һ��case����ѧ�����11��ѧ�֣�Ȼ��assert����isFullTime()��������false
//	�Լ������룬����ʲô����case��������𣿱���...
//	�������ѧ��������
//
//	ѧ������Ϊ�Ϻ�����ѧ���������ѧ����
//
//	����·���isLocal(), ����˵��is��ͷ�ķ�������ֵ��ʲô���͵ģ�
//	��ѧ�����static�ֶ�Student.Local,ֵ��ΪSH
//	����·���SetLocation(String Province),��������ѧ���ļ���
//	���case������һ��ѧ����û�����ü��ᣬassert����isLocal��������false
//	���case������һ��ѧ�������ü���ΪStudent.Local��assert����isLocal��������true
//	���뻹��û��ʲô����case
//	�µı�����
	public static void main(String[] args){
		
	}
}
