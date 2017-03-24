package singleton;

/*
 * 单例模式：最好用的方式，静态内部类，在首次调用getInstance()方法时候才初始化
 */
public class InnerSingleton {
	
	private InnerSingleton(){};

	private static class Singleton{
		private static InnerSingleton single = new InnerSingleton();
	}
	
	public static InnerSingleton getInstance(){
		return Singleton.single;
	}
}
