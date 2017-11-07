package observer;

/**
 * 抽象观察角色
 */
public interface Observer {

	// 调用这个方法更新自己
	public void update(Subject s);
}
