package proxyfactory.demo;

public class Test {

	//访问数据库，这里边是写死的，访问数据库会更换的，下面我们使用工厂方法模式修改一下
	public static void main(String[] args) {
		User user = new User();
		user.setId("1");
		user.setName("小明");
		
		UserService us = new UserService(user);
		us.insert(user);
		
		User u = us.getUser("1");
		System.out.println(u.getName());
	}
}
