package com.store.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.mapper.ShoppingMapper;
import com.store.model.Shopping;
import com.store.service.ShoppingService;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService{
	@Autowired
	private ShoppingMapper shoppingMapper;
	
	public void buyGoods(String goodsName, String userName , double price) {
		shoppingMapper.shopping(goodsName, userName,price);
	}

	public List<Shopping> selectShopping(String userName) {
		return shoppingMapper.selectShopping(userName);
	}

	public int getNum(String name) {
		return shoppingMapper.getNum(name);
	}

	public double total(String name) {
		return shoppingMapper.total(name);
	}

	public void delShopping(int id) {
		shoppingMapper.delShopping(id);
		
	}

}
