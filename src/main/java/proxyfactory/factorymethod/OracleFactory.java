package proxyfactory.factorymethod;

public class OracleFactory implements Factory {

	private User u;
	
	public OracleFactory(User u) {
		this.u = u;
	}

	@Override
	public UserService createUser() {
		return new OracleUserServiceImpl(u);
	}

	@Override
	public IDepartment createDepartment() {
		return new OracleDepartmentImpl(null);
	}

}
