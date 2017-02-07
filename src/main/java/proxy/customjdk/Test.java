package proxy.customjdk;

/**
 * 这里使用的UserService和UserServiceImpl是以上静态代理的例子
 */
public class Test {

	public static void main(String[] args) throws Exception {
		UserHandler handler = new UserHandler(new UserServiceImpl());
		UserService u = (UserService)MyProxy.newProxyInstance(UserService.class,handler);
		u.add();
		u.delete();
	}
}
