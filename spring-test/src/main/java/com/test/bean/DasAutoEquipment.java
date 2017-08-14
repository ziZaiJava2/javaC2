package com.test.bean;

public class DasAutoEquipment implements Equipment {
	CarDAO carDAO;
	public void produceCar(){
		System.out.println("produce DZ");
	}
	public void setCarDAO(CarDAO carDao){
		this.carDAO = carDao;
	}
}
