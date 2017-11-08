package observer.demo2;

import java.util.EventObject;

/**
 * 对读者订阅者改造，时间驱动模式
 * 需要定义一个事件，这代表作者事件，包含一个事件源(作者)
 */
public class WriterEvent extends EventObject {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4561315678792333227L;

	public WriterEvent(Object source) {
		super(source);
	}
}
