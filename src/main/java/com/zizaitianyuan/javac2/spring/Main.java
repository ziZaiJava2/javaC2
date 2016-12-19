package com.zizaitianyuan.javac2.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "services.xml", "daos.xml" });
		Service service=context.getBean("servicesImpl",Service.class);
		Dao dao=context.getBean("MysqlDao",Dao.class);
		System.out.println(service);
		System.out.println(dao);
	}
}
