package proxyfactory.proxyfactory;

public class MysqlUserServiceImpl implements UserService {

	private User u;
	

	@Override
	public void insert(User u) {
		System.out.println("使用mysql添加一条user");
	}

	@Override
	public User getUser(String id) {
		System.out.println("使用mysql查询一个user");
		return u;
	}

}
