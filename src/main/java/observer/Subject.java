package observer;


/**
 * 观察者模式中的抽象主题角色
 */
public interface Subject {
	
	// 调用这个方法增加一个新的观察者对象
	public void attach(Observer o);
	// 调用这个方法删除一个观察者对象
	public void detach(Observer o);
	// 调用这个方法通知所有观察者对象
	public void notifyObservers();
}

