package observer;

/**
 * 对观察者模式的UML图的一个简单诠释，可以看到操作被观察者时，只操作了update方法
 * 观察者们就做出了相应的动作，而添加观察者这个行为是在准备阶段，将具体的观察者关联
 * 到被观察者上去
 */
public class Client {

	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		Observer observer = new ConcreteObserver();
		Observer observer2 = new ConcreteObserver2();
		
		subject.attach(observer);
		subject.attach(observer2);
		subject.notifyObservers();
	}
}
