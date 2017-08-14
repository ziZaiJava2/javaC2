package com.test.bean;

public class CarFatory {
	Equipment equipment;
	public void produce(){
		equipment.produceCar();
	}
	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
	}
}
