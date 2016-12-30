package proxy.movedemo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理：实现InvocationHandler接口，实现方法invoke
public class TestDynamicProxy implements InvocationHandler{
	
	private Object source;
	public TestDynamicProxy(Object source){
		this.source = source;
	}
	public void before(){
		System.out.println("在方法前做一些事，如打开事务");
	}
	public void after(){
		System.out.println("在方法后做一些事，如关闭事务");
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//假如我们切入的是toString(),其他的其实也是类似的，一般都是针对某些方法切入的，比如事务管理器，通常配置就是对
		//save/update/update等方法开启事务
		if(method.getName().equals("toString")){
			before();
		}
		Object result = method.invoke(source, args);
		if(method.getName().equals("toString")){
			after();
		}
		return result;
	}

	public Object getProxy(){
		return Proxy.newProxyInstance(getClass().getClassLoader(), source.getClass().getInterfaces(), this);
	}
}
