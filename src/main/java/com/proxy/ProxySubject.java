package com.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxySubject implements Subject {
	
	private RealSubject real;
	
	private Logger logger = LoggerFactory.getLogger(ProxySubject.class);

	public ProxySubject(RealSubject real) {
		
		this.real = real;
	
	}

	@Override
	public void speak() {
		logger.debug("before execution");

		real.speak();

	}

}
