package proxy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
	通过反射拿到成员变量对象(Field)并使用
	Field[] fields = class1.getFields();得到所有带public修饰的成员方法对象数组
	Field[] fields = class1.getDeclaredFields();得到所有带修饰的成员方法对象数组
	Field field = class1.getDeclaredField("xx");获取xx参数的Field对象
	field.get(Object o)返回指定对象o在此Field对象表示的值
	field.set(Object obj, Object value)将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
 */
public class ReflectField {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		try {
			//拿到字节码文件对象
			Class<?> class1 = Class.forName("proxy.reflect.demo.Student");
			
			Constructor<?> constructor = class1.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object object = constructor.newInstance();
			//Field[] fields = class1.getFields();
			//通过字节码文件对象获取Field对象
			Field[] fields = class1.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			Field field = class1.getDeclaredField("money");
			System.out.println(field.getType());
			System.out.println(field.getName());
			field.setAccessible(true);
			System.out.println("--\n"+field.get(object));
			field.set(object, 2000d);
			System.out.println("--\n"+field.get(object));
		} catch (ClassNotFoundException e) {
			System.out.println("Class not find");
		}
	}
}
