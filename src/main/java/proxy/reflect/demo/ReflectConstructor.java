package proxy.reflect.demo;

import java.lang.reflect.Constructor;

/**
 * 通过反射拿到类的构造方法并使用 
 * class1.getConstructors();拿到public构造方法
 * class1.getDeclaredConstructors();拿到所有构造方法
 * class1.getConstructor(Class<?>... parameterTypes) 
 * 			拿到public修饰的某个个构造方法，参数是可变参数，并且是类字面变量，既是int.class,String.class,Integer.TYPE
 */
public class ReflectConstructor {

	public static void main(String[] args) {
		try {
			//拿到字节码文件对象
			Class<?> class1 = Class.forName("proxy.reflect.demo.Student");
			// 拿到public修饰的构造方法
			// Constructor<?>[] constructors = class1.getConstructors();
			// 拿到所有构造方法
			Constructor<?>[] constructors = class1.getDeclaredConstructors();
			for (Constructor<?> c : constructors) {
				System.out.println(c);
			}
			
			//拿到单个的构造方法对象(无参构造)
			Constructor constructor = class1.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object object = constructor.newInstance();
			System.out.println(object);
			
		} catch (Exception e) {
			System.out.println("Class not find");
		}
	}
}
