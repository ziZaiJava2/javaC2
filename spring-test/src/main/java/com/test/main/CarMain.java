package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.BMWEquipment;
import com.test.bean.CarDAO;
import com.test.bean.CarFatory;
import com.test.bean.DasAutoEquipment;

public class CarMain {
	public static void main(String args[]){
//		Equipment equipment = new BMWEquipment();
//		equipment.produceCar();
		
		//容器的配置
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		//工厂的配置
		CarFatory carFatory = (CarFatory)context.getBean("carFatory");
		
		
		carFatory.produce();

	}
}
