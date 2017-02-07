package proxy.reflect.dbdemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
	解析出保存对象的sql语句
 */
public class DAOUtil {
	
	public static String addSql = "insert into ";
	public static String getSql(Object obj){
		//得到需要加载的类
		Class<?> c = obj.getClass();
			//所有方法
			Method[] methods = c.getDeclaredMethods();
			//得到所有的属性
			Field[] fields = c.getDeclaredFields();
			//得到对象类的名字
			String cName = c.getName();
			//从类的名字中解析表名
			String tableName = cName.substring(cName.lastIndexOf(".")+1,cName.length());
			addSql += tableName +"(";
			List<String> mList = new ArrayList<String>();
	        List<Object> vList = new ArrayList<>();
			for (Method method : methods) {
				String mName = method.getName();
				if(mName.startsWith("get") && !mName.startsWith("getClass")){
					String fieldName = mName.substring(3, mName.length());
					mList.add(fieldName);
					System.out.println("字段名字："+fieldName);
					try {
						Object invoke = method.invoke(obj, null);
						System.out.println("执行方法的返回值："+invoke);
						if(invoke instanceof String){
							vList.add("\"" + invoke + "\"");
							System.out.println("字段值："+invoke);
						}else{
							vList.add(invoke);
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			for (int i = 0; i < mList.size(); i++) {
				if(i<mList.size()-1){
					addSql += mList.get(i)+",";
				}else{
					addSql += mList.get(i)+") values(";
				}
			}
			for (int i = 0; i < vList.size(); i++) {
				if(i<mList.size()-1){
					addSql += vList.get(i)+",";
				}else{
					addSql += vList.get(i)+")";
				}
			}
		return addSql;
	}
	
	public static List<?> getDatasFromDB(String tableName, int Id) {
        return null;
    }
	
	//将对象保存到数据库:返回1添加成功，0添加失败
	public int saveObject(Object obj){
		Connection conn = ConnectDBFactory.getDBConnection();
		String sql = getSql(obj);
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//从数据库取对象
	public Object getObject(String className,String id){
		//得到表名
		String tableName = className.substring(className.lastIndexOf(".")+1,className.length());
		Class<?> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//拼sql
		String sql = "select * from " + tableName + " where Id="+id;
		System.out.println("查询sql语句："+sql);
		//获取数据库连接
		Connection conn = ConnectDBFactory.getDBConnection();
		Object obj = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			Method[] methods = c.getDeclaredMethods();
			while(set.next()){
				obj = c.newInstance();
				for (Method method : methods) {
					String mName = method.getName();
					//如果对象的方法以set开头
					if(mName.startsWith("set")){
						//根据方法名字得到数据表格中字段的名字
						String columnName = mName.substring(3, mName.length());
						//得到方法参数类型
						Class<?>[] types = method.getParameterTypes();
						if(types[0] == String.class){
							//如果参数为String类型，则从结果集中按照列名取出对应值，并执行改set方法
							method.invoke(obj, set.getString(columnName));
						}
						if(types[0] == int.class || types[0] == Integer.class){
							method.invoke(obj, set.getInt(columnName));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
