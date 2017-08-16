package com.test.bean;

public class BMWEquipment implements Equipment{
	CarDAO carDAO;
	public void produceCar(){
		System.out.println("produce BMW");
	}
	public void setCarDAO(CarDAO carDao){
		this.carDAO = carDao;
	}
}
