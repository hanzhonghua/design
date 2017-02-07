package proxy.aopdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MoveProxy implements InvocationHandler {

	public Object object;
	public MoveProxy(Object object){
		this.object = object;
	}
	
	/**
	 * 参数说明：
	 * proxy：被代理的对象
	 * method：被代理对象的方法Method实例
	 * args：方法的参数
	 * 
	 * 返回值：
	 * Object：调用被代理类的方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开启事务");
		Object obj = method.invoke(object, args);
		System.out.println("关闭事务");
		return obj;
	}

}
