package proxyfactory.proxyfactory;

public class OracleUserServiceImpl implements UserService {

	private User u;
	
	@Override
	public void insert(User u) {
		System.out.println("使用oracle添加一条user");
	}

	@Override
	public User getUser(String id) {
		System.out.println("使用oracle查询一个user");
		return u;
	}

}
