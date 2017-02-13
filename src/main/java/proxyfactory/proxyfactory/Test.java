package proxyfactory.proxyfactory;

public class Test {

	//这是我们将工厂接口和具体的实现提取到Data的方法中，不同的数据库连接更改不同的配置
	public static void main(String[] args) {
		UserService user = Data.createUser();
		user.insert(new User());
		user.getUser("1");
		
		IDepartment department = Data.createDepartment();
		department.insert(new Department());
		department.getDepartment("1");
	}
}
