package proxy.customjdk;

import java.lang.reflect.Method;

public class UserHandler implements MyInvocationHandler {

	//被代理对象
	private Object obj;
	
	public UserHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public void invoke(Object o, Method m) {
		try {
			System.out.println("开启事务");
			m.invoke(obj);
			System.out.println("关闭事务");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
