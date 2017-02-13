package proxyfactory.factorymethod;

public class Test {

	// 使用工厂方法模式，一个数据库连接对应一个工厂，工厂和数据库连接接口，
	// 在工厂接口返回数据库连接接口，工厂具体实现对应数据库连接具体实现，
	// 现在只是对应两user和department张表，开发中有很多表，就需要创建很多的类，太麻烦了，
	// 下面看一下代理工厂方法
	public static void main(String[] args) {
		User user = new User();
		user.setId("1");
		user.setName("小明");

		Factory mysqlFactory = new MysqlFactory(user);
		UserService u1 = mysqlFactory.createUser();
		u1.insert(user);
		System.out.println(u1.getUser("1").getName());
		System.out.println("----------");
		Factory oracleFactory = new OracleFactory(user);
		UserService u2 = oracleFactory.createUser();
		u2.insert(user);
		System.out.println(u2.getUser("1").getName());

		IDepartment department = mysqlFactory.createDepartment();
		department.insert(new Department());
		department.getDepartment("1");
		IDepartment department2 = oracleFactory.createDepartment();
		department2.insert(new Department());
		department2.getDepartment("1");
	}
}
