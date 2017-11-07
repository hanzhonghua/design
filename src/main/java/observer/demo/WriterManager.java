package observer.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理器，保留一份独有的作者列表
 */
public class WriterManager {

	private Map<String, Writer> map = new HashMap<>();
	
	// 添加作者
	public void addWriter(Writer w){
		map.put(w.getName(), w);
	}
	
	// 根据作者名获取作者
	public Writer getWriter(String name){
		return map.get(name);
	}
	
	// 单例模式，静态内部类
	private WriterManager(){};
	
	public static WriterManager getInstance(){
		return WriterInstance.wm;
	}
	
	private static class WriterInstance{
		private static WriterManager wm = new WriterManager();
	}
}
