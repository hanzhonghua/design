package proxy.staticdemo2;

//代理类
public class MyProxy implements UserService {

	private UserService us;
	
	public MyProxy(UserService us) {
		this.us = us;
	}

	@Override
	public void add() {
		System.out.println("开启事务");
		us.add();
		System.out.println("开启关闭事务");
	}

	@Override
	public void delete() {
		System.out.println("开启事务");
		us.delete();
		System.out.println("开启关闭事务");
	}

}
