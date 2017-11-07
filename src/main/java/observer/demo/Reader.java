package observer.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * 来看一个实际的小例子，比如经常看的小说网站，都有这样的功能：读者可以订阅作者，这就非常
 * 明显的使用到了观察者模式，就是作者和读者，作者是被观察者，一旦读者观察到作者更新了新书
 * 就会通知读者；除了这两个类之外，还需要添加一个管理器帮我们管理作者的列表以便于读者进行
 * 关注
 * 
 * 其实JDK中已经定义好了观察者接口和被观察者类Observer和Observable 
 */
public class Reader implements Observer {

	private String name;
	
	public String getName() {
		return name;
	}
	
	public Reader(String name) {
		this.name = name;
	}

	// 读者可以关注某一位作者，关注则代表把自己添加到了该作者的观察者列表里
	public void subscribe(String writeName){
		WriterManager.getInstance().getWriter(writeName).addObserver(this);
	}
	
	// 取消关注
	public void unsubscribe(String writeName){
		WriterManager.getInstance().getWriter(writeName).deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Writer){
			Writer w = (Writer) o;
			System.out.println(name+"知道"+w.getName()+"发布了新书《" + w.getLastNovel() + "》，非要去看！");
		}
	}
}
