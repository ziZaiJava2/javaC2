package com.bank.weiwei;

public class BankTest {

	public static void main(String[] args) {
	Person per1 = new Person("1", "ren", 10000 );
	Person per2 = new Person("2", "xiang", 500000 );
	Person per3 = new Person("3", "jie", 800000 );
	Bank ICBC = new Bank();
	ICBC.register(per1);
	ICBC.register(per2);
	ICBC.register(per3);
	ICBC.saveMoney(per1, 5000);
	ICBC.saveMoney(per2, 100000);
	ICBC.saveMoney(per3, 500000);
//	System.out.println(per1.showMyMoney() + per2.showMyMoney()+ per3.showMyMoney());
	per1.showMyMoney();
	per2.showMyMoney();
	per3.showMyMoney();
	}
}
