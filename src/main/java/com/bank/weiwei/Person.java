package com.bank.weiwei;

public class Person {

	private String id;						//身份证号
	private String name;
	private double cashNum;					//现金数量
	private Account myAccount ;				//存款账户
	
	public Person(String id,String name, double cashNum) {
		this.setId(id);
		this.setName(name);
		this.setCashNum(cashNum);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}
	
	public double getCashNum() {
		return this.cashNum;
	}
	
	public void setMyAccount(Account acc) {
		this.myAccount = acc;
	}
	
	public Account getMyAccount() {
		return this.myAccount;
	}
	
	public void showMyMoney() {
		System.out.println(name + "现金有" + cashNum 
							+ "\t银行账户里有:" + myAccount.getMoneyInAccount());
	}
}
