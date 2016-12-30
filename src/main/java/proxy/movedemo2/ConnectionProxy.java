package proxy.movedemo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import proxy.movedemo2.Connection;

//数据库连接代理类(动态代理)
public class ConnectionProxy implements InvocationHandler{
	
	private Connection connection;
	
	public ConnectionProxy(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(Connection.class.isAssignableFrom(proxy.getClass()) && method.getName().equals("close")){
			//将连接归还连接池
			DataSource.getInstance().recoveryConnection(connection);
			return null;
		}else{
			return method.invoke(connection, args);
		}
	}

	public Connection getConnectionProxy(){
		return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
	}
}
