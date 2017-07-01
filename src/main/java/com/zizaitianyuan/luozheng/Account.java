package com.zizaitianyuan.luozheng;

public class Account {// Account.class ��ʾ�����˻�
	String accountId;// �˻���
	double moneyInAccount;// �����

	public Account(String accountId, double money) {
		this.accountId = accountId;
		this.moneyInAccount = money;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getMoneyInAccount() {
		return moneyInAccount;
	}

	public void setMoneyInAccount(double moneyInAccount) {
		this.moneyInAccount = moneyInAccount;
	}

}
