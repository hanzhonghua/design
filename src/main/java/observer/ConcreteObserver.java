package observer;

public class ConcreteObserver implements Observer {

	// 这个方法具体更新自己
	@Override
	public void update(Subject s) {
		System.out.println("I am 观察者1，我观察到了："+s.getClass().getSimpleName()+"发生了变化");
	}
	
}
