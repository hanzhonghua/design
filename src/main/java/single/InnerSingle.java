package single;

/*
 * 单例模式：最好用的方式，静态内部类
 */
public class InnerSingle {

	private static class Singleton{
		private static InnerSingle single = new InnerSingle();
	}
	
	public static InnerSingle getInstance(){
		return Singleton.single;
	}
}
