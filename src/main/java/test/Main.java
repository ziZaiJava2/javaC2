package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Main {

	public static void main(String[] args) {
        //真实对象

		Fibonacci f = new FibonacciImpl();

		InvocationHandler handler = new FibonacciProxy(f);
       //代理对象
		Fibonacci fi = (Fibonacci)Proxy.newProxyInstance(handler.getClass().getClassLoader(), FibonacciImpl.class.getInterfaces(), handler);
		int a = fi.getFibonacci(3);
		
	}

}




