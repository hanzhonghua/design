package singleton;

import java.lang.reflect.Constructor;
import java.text.NumberFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			pool.submit(new Runnable() {
				public void run() {
					Class<InnerSingleton> c = InnerSingleton.class;
					Constructor<InnerSingleton> c2;
					try {
						c2 = c.getDeclaredConstructor();
						
						c2.setAccessible(true);
						InnerSingleton s2 = getInstance();
						InnerSingleton s = c2.newInstance();
						
						System.out.println(s2 == s);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		pool.shutdown();
	}
}
