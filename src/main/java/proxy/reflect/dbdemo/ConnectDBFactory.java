package proxy.reflect.dbdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//读取数据库,用到了反射
public class ConnectDBFactory {

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			//加载com.mysql.jdbc.Driver类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
