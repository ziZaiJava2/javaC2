package com.proxy;

public class Main {
	public static void main(String[] args) {

		RealSubject real = new RealSubject();

		ProxySubject proxy = new ProxySubject(real);

		proxy.speak();

	}
}
