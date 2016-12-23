package springPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = 
			new ClassPathXmlApplicationContext(new String[] { "services.xml", "daos.xml" });
        
		Service service = (Service) context.getBean("service"+Service.class);
		
		System.out.println(service);
	}

}
