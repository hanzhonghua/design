package proxy.staticdemo;

public class RealSubject implements Subject {

	//执行给定名称的任务，打印出任务名，并休眠500ms来模拟任务执行了很长时间
	@Override
	public void doTask(String task) {
		System.out.println("正在执行："+task);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
