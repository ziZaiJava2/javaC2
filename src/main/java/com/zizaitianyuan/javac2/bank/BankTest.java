package com.zizaitianyuan.javac2.bank;

public class BankTest {

	public static void main(String[] args) {
		Person client1=new Person("333333","张三",10000);
		Person client2=new Person("444444","李四",500000);
		Person client3=new Person("555555","王五",800000);
		
		Bank icbc=new Bank();
		icbc.register(client1);
		icbc.register(client2);
		icbc.register(client3);
		
		icbc.saveMoney(client1, 5000);
		icbc.saveMoney(client2, 100000);
		icbc.saveMoney(client3, 500000);
		
		client1.showMyMoney();
		client2.showMyMoney();
		client3.showMyMoney();
		
		
	}

}
