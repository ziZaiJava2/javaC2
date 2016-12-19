package com.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EatProxyMove implements InvocationHandler {

	Object object = new Object();
	
	public EatProxyMove(Object object) {
		this.object = object;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("写完静态代理有点馋");
		Object obj = method.invoke(object, args);
		System.out.println("心满意足");
		return obj;
	}

}
