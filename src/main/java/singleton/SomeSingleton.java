package singleton;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 改造单例模式，可以控制某个类的实例为有限多个
 */
public class SomeSingleton {

	private SomeSingleton() {}

	private static Map<Integer, SomeSingleton> map = new HashMap<>(3);
	private volatile static int num = 1;
	// 控制最多有三个实例
	private static final int MAX_NUM = 3;
	// 锁
	final static ReentrantLock lock = new ReentrantLock();

	public static SomeSingleton getInstance() {
		lock.lock();
		try {
			SomeSingleton instance  = map.get(num);
			if (instance == null) {
				instance = new SomeSingleton();
				map.put(num, instance);
			}
			num++;
			if (num > MAX_NUM) {
				num = 1;
			}
			return instance;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final Set<Integer> set = new HashSet<>();
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10000; i++) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					// System.out.println(getInstance().hashCode());
					set.add(getInstance().hashCode());
				}
			});
		}
		System.out.println(set.size());
		pool.shutdown();
	}
}
