package single;

/*
 * 单例模式：双重检测机制
 */
public class DoubleSingle {

	private static DoubleSingle ds;
	
	public static DoubleSingle getInstance(){
		if(ds == null){
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			synchronized (DoubleSingle.class) {
				ds = new DoubleSingle();
			}
		}
		return ds;
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				System.out.println(getInstance().hashCode());
			}
		}).start();
	}
}
