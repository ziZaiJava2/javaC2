package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciProxy implements InvocationHandler {

	private Object m;

	public FibonacciProxy(Object m) {
		this.m = m;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("don't user cache");

		Object result = method.invoke(m, args);

		System.out.println(result);

		System.out.println("after use cache ");

		return result;
	}

}
