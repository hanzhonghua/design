package proxy.movedemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理原理，一个类/接口想要可以被动态代理，必须实现InvocationHandler，重写invoke方法
public class DynamicProxy implements InvocationHandler {

	private Object source;

	public DynamicProxy(Object source) {
		this.source = source;
	}

	/*
	 * @Override public Object invoke(Object proxy, Method method, Object[]
	 * args) throws Throwable { System.out.println("接口的方法变样啦"); return
	 * method.invoke(source, args); //return null; }
	 */

	// 以上的实现是被代理类必须实现接口才可以的，不实现就看只需要加一下两句代码即可
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Method sourceMethod = source.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
		sourceMethod.setAccessible(true);
		Object result = sourceMethod.invoke(source, args);
		System.out.println("after");
		return result;
	}

	public static void main(String[] args) {
		// 代理的入口
		TestInterface o = (TestInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] { TestInterface.class }, new DynamicProxy(new TestClass()));
		o.method1();
		o.method2();
		o.method3();
		
	}
}
