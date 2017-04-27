package singleton.enumt;

/*
 * 使用枚举enum实现单例模式，更加简洁，也不用担心被反射攻击或是反序列化，在多线程中也很安全
 * java1.5之后提供的
 */
public enum SingletonEnum {
	
	INSTANCE;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(SingletonEnum.INSTANCE.hashCode());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(SingletonEnum.INSTANCE.hashCode());
			}
		});
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(SingletonEnum.INSTANCE.hashCode());
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
