package com.zizaitianyuan.javac2.bank;

public class Person {
	String id;
	String name;
	double cashNum;
	private Account myAccount =null;
	
	public Person(String id,String name,double cashAccount){
		this.id = id;

		this.name = name;

		this.cashNum = cashAccount;
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

	public double getCashNum() {
		return cashNum;
	}

	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public Account getMyAccount() {
		
		this.myAccount=Bank.register(this);
		 
		return myAccount;
	}

	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public void showMyMoney() {

		System.out.println( "个人身上现金余额：" + cashNum + "当前存款金额："

				+myAccount.getMoneyInAccount());

	}

	


}
