package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 * 单例模式：最好用的方式，静态内部类，在首次调用getInstance()方法时候才初始化
 */
public class InnerSingleton {
	
	private InnerSingleton(){}
	private static class Singleton{
		private static  InnerSingleton single = new InnerSingleton();
	}
	
	public static InnerSingleton getInstance(){
		return Singleton.single;
	}
	
	public static void main(String[] args) {
		/*getInstance();
		getInstance();
		getInstance();
		getInstance();*/
		
		try {
			Class<Singleton> c = Singleton.class;
			Constructor<Singleton> c2 = c.getDeclaredConstructor();
			c2.setAccessible(true);
			Singleton s = c2.newInstance();
			InnerSingleton s2 = s.single;
			InnerSingleton s3 = getInstance();
			System.out.println(s2 == s3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
