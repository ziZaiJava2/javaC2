package com.bank.weiwei;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	public Map<String, Person> accountMap = new HashMap<String,Person>();
	
	public Account register(Person person) {
		Account acc = new Account(person.getId(), 0);
		person.setMyAccount(acc);
		accountMap.get(acc);
		return acc;
	}
	
	public boolean saveMoney(Person person, double moneyNum) {
		if(person.getMyAccount().getAccountId().equals(null)){
			System.out.println("请先注册银行账户");
			return false;
		}else{
			if(person.getCashNum() < moneyNum) {
				System.out.println("现金不足");
				return false;
				
			}else{
				person.getMyAccount().setMoneyInAccount(moneyNum);
				person.setCashNum(person.getCashNum() - moneyNum);
				return true;
			}
		}
	}
}
