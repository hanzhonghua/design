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
		//加载文件中的键值对数据
		Properties p = new Properties();
		/**
			JavaAPI：查找与给定类相关的资源的规则是通过定义类的 class loader 实现的,此方法委托此对象的类加载器,
			 如果此对象通过引导类加载器加载,则此方法将委托给 ClassLoader.getSystemResourceAsStream(String)。
			通过以上说明此处可以填写任意类，因为这些类都会有由加载器加载，最后都是调用类加载器的方法;
			所以此处写Object.class、String.class、ReflectProperty.class等等都时可以的。
		*/
		InputStream is = ReflectProperty.class.getResourceAsStream("/config.properties");
		p.load(is);
		is.close();
		System.out.println("数据库链接:"+p.getProperty("dbName")+"\n用户名:"+p.getProperty("username")+"\n密码:"+p.getProperty("password"));
	}
	
	public void test(){
		getClass().getResourceAsStream("");
	}
}
