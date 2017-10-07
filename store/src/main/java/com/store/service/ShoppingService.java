package com.store.service;

import com.store.model.Shopping;

import java.util.List;

public interface ShoppingService {
	public void buyGoods(String goodsName,String userName,double price);
	
	public List<Shopping> selectShopping(String userName);

	public int getNum(String name);

	public double total(String name);

	public void delShopping(int id);
}
