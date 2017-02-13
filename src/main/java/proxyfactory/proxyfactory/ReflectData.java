package proxyfactory.proxyfactory;

import java.io.InputStream;
import java.util.Properties;

import proxy.reflect.purpose.ReflectProperty;

public class ReflectData {

	//不同的数据库连接
	private static final String db = "mysql";
	//private static final String db = "oracle";
	
	/**
	 * 系统之中不可以就几个表，另外数据库连接也有可能编程sqlserver
	 * 此时我们使用反射来优化Data
	 */
	/**
	 * 返回具体的产品实现类对象
	 * c 具体哪个产品接口
	 * @throws Exception 
	 * @throws InstantiationException 
	 */
	public  Object create(Class<?> c) throws Exception{
		if("mysql".equals(db)){
			return new MysqlUserServiceImpl();
		}else if("oracle".equals(db)){
			return new OracleUserServiceImpl();
		}
		Properties p = new Properties();
		InputStream is = Object.class.getResourceAsStream("/db.properties");
		p.load(is);
		is.close();
		System.out.println(p.getProperty("db"));
		return null;
	}
	public static void main(String[] args) throws Exception{
	}
}
