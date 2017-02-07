package proxy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
	通过反射拿到成员变量对象(Field)并使用
	Field[] fields = class1.getFields();得到所有带public修饰的成员方法对象数组
	Field[] fields = class1.getDeclaredFields();得到所有带修饰的成员方法对象数组
	Field field = class1.getDeclaredField("xx");获取xx参数的Field对象
	field.get(Object o)返回指定对象o在此Field对象表示的值
	field.set(Object obj, Object value)将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
 */
public class ReflectField {

	public static void main(String[] args) throws Exception{
		//拿到字节码文件对象
		Class<?> class1 = Class.forName("proxy.reflect.demo.Student");
		//直接使用字节码文件对象创建对象实例，默认调用的是无参构造，而无参构造是private修饰的，所以会抛异常
		Object object = class1.newInstance();
		//Field[] fields = class1.getFields();
		
		//通过字节码文件对象获取Field对象
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		//只能获取带public修饰的
//		Field field = class1.getField("age");
		Field field = class1.getDeclaredField("age");
		field.setAccessible(true);
		System.out.println("-------");
		System.out.println(field);
		System.out.println("-------");
		System.out.println(field.getType());
		System.out.println(field.getName());
		System.out.println("--\n"+field.get(object));
		field.set(object, 2000);
		System.out.println("--\n"+field.get(object));
		System.out.println(field.getModifiers());
		System.out.println(field.getType());
		System.out.println(field.getName());
	}
}
