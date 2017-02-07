package proxy.staticdemo2;

//测试类
public class Test {

	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		MyProxy proxy = new MyProxy(us);
		proxy.add();
		proxy.delete();
	}
}
