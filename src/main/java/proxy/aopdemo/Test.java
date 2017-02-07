package proxy.aopdemo;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		UserServiceImpl us = new UserServiceImpl();
		//动态代理的入口
		//参数一：类加载器
		//
		UserService obj = (UserService)Proxy.newProxyInstance(UserService.class.getClassLoader(), UserServiceImpl.class.getInterfaces(),new MoveProxy(us));
		obj.add();
		obj.update();
		obj.delete();
		obj.get();
	}
}
