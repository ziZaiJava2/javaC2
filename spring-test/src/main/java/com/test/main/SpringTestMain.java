package com.test.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.bean.UserServiceImpl;
public class SpringTestMain {
	public static void main(String args[]){
		
		//ÈÝÆ÷µÄÅäÖÃ
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		
		UserServiceImpl userServiceImpl = (UserServiceImpl)context.getBean("userServiceImpl");
		
		
		userServiceImpl.getUser();
		//UserServiceImpl userServiceImpl1 = new UserServiceImpl(userDao);
	}
}
