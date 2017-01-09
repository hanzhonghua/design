package proxy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
	通过反射拿到成员方法
	Method[] methods = c.getMethods();得到所有public修饰的方法Method对象数组
	Method[] methods = c.getDeclaredMethods();得到所有方法Method对象数组
	getDeclaredMethod(String name, Class<?>... params) 得到某一方法method对象，name是方法名，params是参数.class
	
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
		Method m = c.getMethod("learn"); //拿到方法名为learn并且没有形参的方法对象
		m.invoke(object); //该代码意思就是调用object对象的m方法
		Method m2 = c.getMethod("learn",String.class); //拿到方法名为learn参数是String类型的方法对象
		m2.invoke(object, "小明"); //该代码意思就是调用object对象的m方法并给参数赋值为"小明"
		System.out.println("--\n"+m);
	}
}
