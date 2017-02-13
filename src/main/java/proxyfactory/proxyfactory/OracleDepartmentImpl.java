package proxyfactory.proxyfactory;

public class OracleDepartmentImpl implements IDepartment {

	private Department d;
	
	@Override
	public void insert(Department d) {
		System.out.println("使用oracle添加一条Department");
	}

	@Override
	public Department getDepartment(String id) {
		System.out.println("使用oracle根据id查询一条Department");
		return d;
	}

}
