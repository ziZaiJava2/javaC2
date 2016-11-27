package com.bank;

public class Person {
	private String id;          //身份证号
	private String name;        //姓名
	private double cashNum;     //现金数
//Account myAccount 自己的存款账户， 开始为null。 后面需要去调用Bank的 register方法去获取一个账户。
	private Account myAccount = null;
	
//构造方法
//需要自己写一个三个参数的构造方法， 三个参数分别为 id， name， 现金金额
	public Person(String id,String name,double cashNum){
		this.id = id;
		this.name = name;
		this.cashNum = cashNum;
	}

//为每个成员变量写对应的getter和setter方法。
//	获取身份证号
	public String getId(){
		return this.id;
	}
//	修改身份证号
	public void setId(String id){
		this.id = id;
	}
//	或许姓名
	public String getName(){
		return this.name;
	}
//	修改姓名
	public void setName(String name){
		this.name = name;
	}
//	获取现金数
	public double getCashNum(){
		return this.cashNum;
	}
//	修改现金数
	public void setCashNum(double cash){
		this.cashNum = cash;
	}
//	获取myAccount
	public Account getMyAccount(){
		return this.myAccount;
	}
//	修改myAccount
	public void setMyAccount(Account myAccount){
		this.myAccount = myAccount;
	}
//void showMyMoney() 打印出这个人有多少现金，和银行账户里有多少钱。
	public void showMyMoney(){
		System.out.println("身份证："+ this.id 
				+ "姓名:"+ this.name
				+ "现金金额:" +  this.cashNum
				+ "银行账户余额:" + this.myAccount.getMoneyInAccount());
	}
}
