package proxy.reflect.demo;

import java.lang.reflect.Constructor;

public class ReflectStudentDemo {

	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("proxy.reflect.demo.Student");
			Constructor<?>[] constructors = class1.getConstructors();
			for (Constructor<?> c : constructors) {
				System.out.println(c);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class not find");
		}
	}
}
