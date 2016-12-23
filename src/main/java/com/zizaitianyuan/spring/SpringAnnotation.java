package com.zizaitianyuan.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zizaitianyuan.spring.beans.Service;

public class SpringAnnotation {

	private static Logger logger = LoggerFactory.getLogger(SpringAnnotation.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"annotation.xml"});
	
		Service service = context.getBean("service", Service.class);
		logger.info(service.toString());;
		
	}
}
