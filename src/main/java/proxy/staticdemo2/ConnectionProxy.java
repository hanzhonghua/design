package proxy.staticdemo2;

import java.sql.SQLException;
import java.sql.Statement;

//数据库连接代理类
public class ConnectionProxy implements Connection {

	private Connection connection;
	
	public ConnectionProxy(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public Statement createStatment() throws SQLException {
		return connection.createStatment();
	}
	//调用close方法时实际上是将请求转给了委托类DataSource用来归还连接
	@Override
	public void close() throws SQLException {
		DataSource.getInstance().recoveryConnection(connection);
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


}
