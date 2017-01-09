package proxy.reflect.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 	反射读取配置文件
	通过java.lang.Class 的getResourceAsStream("xx")读取;如果xx前不加/，代表从当前包下查询，如果加/，
		代表从classes文件夹下查询
	一个小问题：在static方法中，不能使用getClass()，因为在java中getClass().get...就相当于this.getClass().get..
		只不过this省略了，在static中是无法使用this的，static方法 随着类的加载而加载，this代表本类对象，此时对象还没有
		被加载，所以不能用。
	
 */
public class ReflectProperty {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
//		FileInputStream is = new FileInputStream("config/config.properties");
		InputStream is = ReflectProperty.class.getResourceAsStream("/config.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			System.out.println("读取配置文件失败或者配置文件不存在");
		}
		System.out.println(p.getProperty("name")+":"+p.getProperty("age"));
	}
	
	public void test(){
		getClass().getResourceAsStream("");
	}
}
