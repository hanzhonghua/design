package proxy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
	通过反射拿到成员方法
	Method[] methods = c.getMethods();得到所有public修饰的方法Method对象数组
	Method[] methods = c.getDeclaredMethods();得到所有方法Method对象数组
	
 */
public class ReflectMethod {

	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("proxy.reflect.demo.Student");
		Constructor<?> constructor = c.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object object = constructor.newInstance();
		//Method[] methods = c.getMethods();
		Method[] methods = c.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m);
		}
		Method m = c.getMethod("learn");
		Object invoke = m.invoke(object);
		System.out.println(invoke);
		System.out.println("--\n"+m);
	}
}
