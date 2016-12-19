package com.fe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FibonacciProxy implements InvocationHandler{
	private Object obj;
	public FibonacciProxy(Object fib){
		this.obj=fib;
	}
	//public Object invoke
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o=method.invoke(obj, args);		//实现FibonacciReal里的getFib方法	
		return o;
	}

}
