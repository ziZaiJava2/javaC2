package com.zizaitianyuan.javac2.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private static Map<String,Person> accountMap=new HashMap<String,Person>();
	
	public static Account register(Person person){
		Account account=new Account(person.getId(),0); 
		accountMap.put(person.getId(),person);
		
		return account;
		
	}
	public boolean saveMoney(Person person,double moneyNum){
		if(!accountMap.containsKey(person.getId())){
			System.out.println("请先注册银行账户");
			return false;
			}
		else {
			if(person.getCashNum()>=moneyNum){
				person.getMyAccount().setMoneyInAccount(moneyNum);
		        person.setCashNum(person.getCashNum()-moneyNum);
			    return true;
			}else{
				System.out.println("现金不足");
                return false;
			}
				
		
		}
	}
	

}
