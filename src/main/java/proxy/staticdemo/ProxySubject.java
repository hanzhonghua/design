package proxy.staticdemo;

//代理类
public class ProxySubject implements Subject {

	//保存一个委托类的引用
	private RealSubject realSubject;
	
	public ProxySubject(RealSubject realSubject){
		this.realSubject = realSubject;
	}
	
	@Override
	public void doTask(String task) {
		long stime = System.currentTimeMillis();
		//将请求交给委托类
		realSubject.doTask(task);
		long etime = System.currentTimeMillis();
		System.out.println("执行耗时："+(etime-stime)+"毫秒");
	}
}
