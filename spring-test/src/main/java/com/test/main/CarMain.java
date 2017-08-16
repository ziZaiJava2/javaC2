package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.BMWEquipment;
import com.test.bean.CarDAO;
import com.test.bean.DasAutoEquipment;

public class CarMain {
	public static void main(String args[]){
//		Equipment equipment = new BMWEquipment();
//		equipment.produceCar();
		
		//容器的配置
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		//大众的配置
		DasAutoEquipment dasAutoEquipment = (DasAutoEquipment)context.getBean("dasAutoEquipment");
		
		//宝马的配置	
		BMWEquipment bmwEquipment = (BMWEquipment)context.getBean("bmwEquipment");
		
		dasAutoEquipment.produceCar();
		bmwEquipment.produceCar();
	}
}
