package proxy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射拿到类的构造方法并使用 
 * class1.getConstructors();拿到public构造方法
 * class1.getDeclaredConstructors();拿到所有构造方法
 * class1.getConstructor(Class<?>... parameterTypes) 
 * 			拿到public修饰的某个个构造方法对象，参数是可变参数，并且是类字面变量，既是int.class,String.class,Integer.TYPE
 * Constructor.newInstance(Object... initargs)创建该构造方法的声明类实例，参数是对应的23，"杰克"
 * 			相当于new Student("杰克",24);
 * 对于private修饰的需要设置constructor.setAccessible(true)避过java的java语法检查，即可调用
 */
public class ReflectConstructor {

	public static void main(String[] args) throws Exception{
		//拿到字节码文件对象
		Class<?> c = Class.forName("proxy.reflect.demo.Student");
		// 拿到public修饰的构造方法
		 Constructor<?>[] constructors = c.getConstructors();
		// 拿到所有构造方法
//		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		//拿到单个的构造方法对象(无参构造)
		//Constructor<?> constructor = class1.getDeclaredConstructor();
		//Object object = constructor.newInstance();
		//带参数的构造方法
		Constructor<?> constructor = c.getDeclaredConstructor(String.class,Integer.class);
		constructor.setAccessible(true);
		Object object = constructor.newInstance("小明",24);
		System.out.println(object);
	}
}
