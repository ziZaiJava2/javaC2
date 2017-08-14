package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.CarDAO;
import com.test.bean.DasAutoEquipment;

public class CarMain {
	public static void main(String args[]){
//		Equipment equipment = new BMWEquipment();
//		equipment.produceCar();
		
		//ÈÝÆ÷µÄÅäÖÃ
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		DasAutoEquipment dasAutoEquipment = (DasAutoEquipment)context.getBean("dasAutoEquipment");
		
		dasAutoEquipment.produceCar();
	}
}
