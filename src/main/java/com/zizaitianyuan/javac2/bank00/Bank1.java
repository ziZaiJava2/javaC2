package com.zizaitianyuan.javac2.bank00;

import java.util.HashMap;
public class Bank1{
	public static void main(String[] args){
		Person p1 = new Person("13454213","李刚",10000);
		Person p2 = new Person("13454245","张宏",500000);
		Person p3 = new Person("13454289","梁欣欣",800000);
		Bank icbc = new Bank();
		Bank.register(p1);
		Bank.register(p2);
		Bank.register(p3);
		icbc.saveMoney(p1, 5000);
		icbc.saveMoney(p2, 100000);
		icbc.saveMoney(p3, 500000);
		p1.showMyMoney();
		p2.showMyMoney();
		p3.showMyMoney();
	}
	
}

class Person {
	private String id;   //身份证号
	private String name;    //用户姓名
	private double cashNum;    //个人身上的现金数额
	private Account myAccount = null;    //存款账户
	
	public Person(String id,String name,double cashNum){
		this.setId(id);
		this.setName(name);
		this.setCashNum(cashNum);
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCashNum(double cashNum){
		this.cashNum = cashNum;
	}
	
	public double getCashNum(){
		return cashNum;
	}
	
	public void showMyMoney(){
		System.out.println("现金数额："+getCashNum()+"存款金额"+myAccount.getMoneylnAccount());
		
	}
	
	public Account getMyAccount(){
		this.myAccount = Bank.register(this);
		return myAccount;
	}
}


class Bank{
	private static HashMap<String,Person> accountMap = new HashMap<String,Person>();
	
	public static Account register(Person person){
		Account account = new Account(person.getId(),0);
		accountMap.put(person.getId(), person);
		return account;
	}
	
	public boolean saveMoney(Person person,double moneyNum){
		if(!accountMap.containsKey(person.getId())){
			System.out.println("请先注册银行账户");
			return false;
		}else{
			if(person.getCashNum() < moneyNum){
				System.out.println("现金不足");
				return false;
			}else{
				accountMap.get(person.getId()).getMyAccount().setMoneylnAccount(moneyNum);
				person.setCashNum(person.getCashNum() - moneyNum);
				return true;
			}
		}
	}
}





class Account{
	private String accountld;   //账户号
	private double moneylnAccount;    //存款金额
	
	public Account(String accountld,double moneylnAccount){
		setAccountld(accountld);
		setMoneylnAccount(moneylnAccount);
	}
	
	public void setAccountld(String accountld){
		this.accountld = accountld;
	}
	
	public String getAccountld(){
		return accountld;
	}
	
	public void setMoneylnAccount(double moneylnAccount){
		this.moneylnAccount += moneylnAccount;
	}
	
	public double getMoneylnAccount(){
		return moneylnAccount;
	}
}




