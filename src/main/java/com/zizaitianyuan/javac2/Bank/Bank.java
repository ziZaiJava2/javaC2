package com.zizaitianyuan.javac2.Bank;
import java.util.*;
/**
 * Created by SPIDER on 2017/6/30.
 */
public class Bank {
    private Map<String,Account> accountMap=new HashMap<String,Account>();

    public Account register(Person person){
        Account account=new Account(person.getId(),0);
        person.setMyAccount(account);
        accountMap.put(account.getAccountId(),account);
        return account;
    }

    public boolean saveMoney(Person person,double moneyNum){
        if(!accountMap.containsKey(person.getId())){
            System.out.println("请先注册银行账户");
            return false;
        }
        if(person.getCashNum()<moneyNum){
            System.out.println("现金不足");
            return false;
        }
        Account account=accountMap.get(person.getId());
        account.setMoneyInAccount(account.getMoneyInAccount()+moneyNum);
        accountMap.put(person.getId(),account);
        person.setCashNum(person.getCashNum()-moneyNum);
        return true;
    }
}
