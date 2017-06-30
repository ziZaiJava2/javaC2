package com.zizaitianyuan.javac2.Bank;

/**
 * Created by SPIDER on 2017/6/30.
 */
public class BankTest {
    public static void main(String[] args){
        Person p1=new Person("001","Mary",10000);
        Person p2=new Person("002","Peter",500000);
        Person p3=new Person("003","Alice",800000);
        Bank icbc=new Bank();
        icbc.register(p1);
        icbc.register(p2);
        icbc.register(p3);
        icbc.saveMoney(p1,5000);
        icbc.saveMoney(p2,100000);
        icbc.saveMoney(p3,500000);
        p1.showMyMoney();
        p2.showMyMoney();
        p3.showMyMoney();
    }
}
