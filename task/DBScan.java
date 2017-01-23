package com.java2.web.task;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.java2.web.Service.UserServicelmp;

@Component
public class DBScan {
		
	@SuppressWarnings("restriction")
	@PostConstruct
	public void postConStruct(){
		ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
		es.scheduleAtFixedRate(new Runnable(){
			public void run(){
				System.out.println("ע");
				Date date = null;
				for(Map.Entry<String, Date> entry : UserServicelmp.map.entrySet()){
					date = new Date();
					if(((date.getTime()-entry.getValue().getTime())/1000)/60 > 15){
						UserServicelmp.map.remove(entry.getKey());
					}
					entry.setValue(date);
				}
			}
		}, 0, 1, TimeUnit.MINUTES);
	}
}
