package proxy.movedemo2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

//模拟数据库连接池
public class DataSource{

	private static LinkedList<Connection> connectionList = new LinkedList<>();
	static {
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection createNewConnection() throws SQLException{
		return (Connection) DriverManager.getConnection("", "", "");
	}
	
	private DataSource(){
		if(connectionList == null || connectionList.size() == 0){
			for (int i = 0; i < 10; i++) {
				try {
					connectionList.add(createNewConnection());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Connection getConnection(){
		if(connectionList.size()>0){
			return (Connection)new ConnectionProxy(connectionList.remove());
		}else{
			return null;
		}
	}
	
	public void recoveryConnection(Connection c){
		connectionList.add(c);
	}
	
	public static DataSource getInstance(){
		return DataSourceInstance.dataSource;
	}
	private static class DataSourceInstance{
		private static DataSource dataSource = new DataSource();
	}
}
