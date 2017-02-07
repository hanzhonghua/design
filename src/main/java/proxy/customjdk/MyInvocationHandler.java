package proxy.customjdk;

import java.lang.reflect.Method;

//定义自己的InvocationHandler
public interface MyInvocationHandler {

	/**
	 * @param o 代理对象
	 * @param m 被代理方法
	 */
	public void invoke(Object o,Method m);
}
