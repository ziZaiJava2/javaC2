package dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DaiLi implements InvocationHandler {

	private BeiDaili say;
	
	public DaiLi(BeiDaili sa) {
		this.say = sa;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object answer = method.invoke(say, args);
		return answer;
	}

}
