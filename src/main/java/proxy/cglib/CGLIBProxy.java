package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxy implements MethodInterceptor {
	
	private Enhancer e = new Enhancer();
	
	public Object getCGLIBProxy(Class<?> clazz){
		//设置为clazz类生成代理
		e.setSuperclass(clazz);
		e.setCallback(this);
		//生成代理类实例
		return e.create();
	}

	/**
	 * 拦截所有目标类的方法
	 * 参数：
	 * obj 被代理类实例
	 * m 被代理类方法
	 * args 方法的参数
	 * proxy 代理类对象
	 */
	@Override
	public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println(obj.getClass().getName());
		System.out.println(m.getName());
		System.out.println(args);
		System.out.println(proxy.getClass().getName());
		System.out.println("开启事务");
		long start = System.currentTimeMillis();
		Object result = null;
		//调用父类方法
		result = proxy.invokeSuper(obj, args);
		long end = System.currentTimeMillis();
		System.out.println("关闭事务");
		System.out.println("执行耗时："+(end-start)+"毫秒");
		return result;
	}

}
