package proxy.reflect.purpose;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectProperty {

	public static void main(String[] args) throws Exception {
		//用来加载键值对数据
		Properties prop = new Properties();
		InputStream inStream = ReflectProperty.class.getResourceAsStream("/config.properties");
		prop.load(inStream);
		String className = prop.getProperty("className");
		String methodName = prop.getProperty("methodName");
		
		Class<?> c = Class.forName(className);
		Object obj = c.newInstance();
		Method method = c.getMethod(methodName,String.class);
		Object result = method.invoke(obj, "小明");
		System.out.println(result);
	}
}
