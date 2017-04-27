package singleton;

/*
 * 单例模式：饿汉式，优点：不需要考虑线程安全问题
 * 缺点：在类被加载时，静态变量就会被初始化，如果一个对象的初始化需要花费很长时间而又没有得到使用
 * 因此在资源利用率这一方面，不及懒汉式，在系统加载时需要创建饿汉式单例对象，加载时间会稍微长点
 * 
 */
public class HungarySingleton {

	private HungarySingleton(){
		try {
			//假设创建对象需要耗费一定时间
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	//静态方法
	private static final HungarySingleton instance = new HungarySingleton();
	
	//必须使用static，如果不加就需要调用方创建实例然后调用，而构造函数是私有的
	public static HungarySingleton getInstance(){
		return instance;
	}
	
	public static void main(String[] args) {
		/*
		 * 单线程环境没有问题
		 */
//		System.out.println(getInstance().hashCode());
//		System.out.println(getInstance().hashCode());
		
		/*
		 * 多线程环境依然没有问题
		 */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
