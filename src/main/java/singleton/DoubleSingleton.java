package singleton;

/*
 * 单例模式：双重检测机制，该机制针对懒汉式单例模式的改造，无非就是在同步的外边报了一层判断，这样真的
 * 有用么 ？？？
 */
public class DoubleSingleton {

	private volatile static DoubleSingleton ds;
	private DoubleSingleton(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	/*
	 * 代码中1出的判断可以理解，同步实际上是非常浪费性能的，那么有没有一个方法减少同步的开销不就更好了么，因此1出代码出现了
	 * 为什么还需要3出的非空判断呢，首先说明一下如果不加3处的非空判断在多线程
	 * 环境下任然会产生多个对象。原因：假如现在有三个线程AB都执行到了1出的非空判断了，在向下执行时候发现有
	 * 锁，假如现在A线程获取了锁，线程B等待，在线程A拿到创建好对象释放锁B线程获得锁的时候，还不知道A线程
	 * 已经创建过对象了，这就会导致出现多个对象，所以需要加上3出的判断，但是，这样真的有用么？？？
	 * 
	 * 线程AB首次访问getInstance()方法时，此时ds为null，因此AB几乎会在同一时间到达代码1处，此时ds对象位null
	 * 继续向下走到2处，假设线程A获得了锁继续向下执行，而线程B只能在2出等待，线程A执行到4时创建对象并返回然后释放锁并退出方法
	 * 线程B拿到锁向下执行到3处，此时ds已经不为null，释放锁并退出方法。可以看到同步化是避免多个线程同时初始化这个类，
	 * 而不是避免同时调用这个静态方法。
	 * 
	 * 然而在Java编译器中，DoubleSingleton类的初始化和ds变量的赋值顺序不可预料的，如果一个线程在没有同步化条件下读取了ds引用
	 * 并调用这个对象的方法的话，可能会发现对象初始化尚未完成，从而造成程序异常。
	 * 
	 * 此时volatile关键字就出场了，该关键字确保当ds变量被初始化成DoubleSingleton实例时，多个线程可以正确的处理ds变量，使用
	 * volatile关键字可以让程序以正常的顺序执行，JDK版本必须是1.5后的，1.5后增强了volatile的功能才可以使用。
	 * 
	 * 可以看到饿汉式占用内存，懒汉式处理繁琐，那么有没有一种结合了两者有点的方法呢？静态内部类可以完成！！！！
	 */
	public static DoubleSingleton getInstance(){
		if(ds == null){                             //1
			//此处会有多个线程同时到达				//2
			synchronized (DoubleSingleton.class) {
				if (ds == null) {                    //3
					ds = new DoubleSingleton();      //4
				}
			}
		}
		return ds;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t2");
		Thread t3 =new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		},"t3");
		t1.start();
		t2.start();
		t3.start();
	}
	
}
