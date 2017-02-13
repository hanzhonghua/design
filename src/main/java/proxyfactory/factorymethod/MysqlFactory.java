package proxyfactory.factorymethod;

public class MysqlFactory implements Factory {

	private User u;
	
	public MysqlFactory(User u) {
		this.u = u;
	}
	
	@Override
	public UserService createUser() {
		return new MysqlUserServiceImpl(u);
	}

	@Override
	public IDepartment createDepartment() {
		return new MysqlDepartmentImpl(null);
	}

}
