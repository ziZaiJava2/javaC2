package com.zizaitianyuan.luozheng;

public class BankTest {

	public static void main(String[] args) {
		Person p1 = new Person("1","a",10000);
		Person p2 = new Person("2","b",500000);
		Person p3 = new Person("3","c",800000);
		Bank icbc = new Bank();
		icbc.register(p1);
		icbc.register(p2);
		icbc.register(p3);
		icbc.saveMoney(p1, 5000);
		icbc.saveMoney(p2, 100000);
		icbc.saveMoney(p3, 500000);
		p1.showMyMoney();
		p2.showMyMoney();
		p3.showMyMoney();
		

	}

}
