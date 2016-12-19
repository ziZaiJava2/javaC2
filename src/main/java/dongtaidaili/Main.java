package dongtaidaili;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {

		BeiDaili sa = new BeiDaili();
		DaiLi sing = new DaiLi(sa);
		Action answer = (Action) Proxy.newProxyInstance(sa.getClass().getClassLoader(), sa.getClass().getInterfaces(), sing);
		answer.say();
	}

}
