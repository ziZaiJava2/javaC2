package com.zizaitianyuan.luozheng;

import com.zizaitianyuan.luozheng.Account;

public class Person {// Person.class �������
	String id;// ���֤��
	String name;//
	double cashNum;// �������ϵ��ֽ�����
	Account myAccount;// �Լ��Ĵ���˻��� ��ʼΪnull�� ������Ҫȥ����Bank��
						// register����ȥ��ȡһ���˻���

	public Person(String id, String name, double cashNum) {
		this.id = id;
		this.name = name;
		this.cashNum = cashNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getcashNum() {
		return cashNum;
	}

	public void setcashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public void showMyMoney() {
		System.out.println("�ֽ�" + cashNum + "\n" + "�˻���" + myAccount.moneyInAccount);
	}

}
