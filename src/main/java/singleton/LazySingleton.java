package singleton;

/*
 * 单例模式：懒汉式,又称为延迟加载，在需要调用的时候才去创建对象，但是在多线程环境下，会创建多个对象
 * 做修改在方法上加锁，synchronized，这样做就会导致在多线程下性能非常低，每个线程进来之后都需要获取锁
 * 在改进看DoubleSingleton
 */
public class LazySingleton {

	private LazySingleton(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	private static LazySingleton ls;
	
	public synchronized static LazySingleton getInstance(){
		if(ls == null){
			ls = new LazySingleton();
		}
		return ls;
	}
	
	public static void main(String[] args) {
		/*
		 * 单线程环境没有问题
		 */
//		System.out.println(getInstance().hashCode());
//		System.out.println(getInstance().hashCode());
		
		/*
		 * 多线程环境出现问题，产生了多个对象
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
