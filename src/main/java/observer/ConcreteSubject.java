package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的主题角色
 */
public class ConcreteSubject implements Subject {
	
	private List<Observer> observers = new ArrayList<>();

	// 向观察者集合添加一个观察者
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	// 从观察者集合中删除一个观察者
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	// 遍历观察者集合，调用每一个观察者的响应方法
	@Override
	public void notifyObservers() {
		System.out.println("我是被观察者，我要变化啦");
		for (Observer o : observers) {
			o.update(this);
		}
	}

}
