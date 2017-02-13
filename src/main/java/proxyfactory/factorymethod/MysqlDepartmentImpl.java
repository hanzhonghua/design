package proxyfactory.factorymethod;

public class MysqlDepartmentImpl implements IDepartment {

	private Department d;
	
	public MysqlDepartmentImpl(Department d) {
		this.d = d;
	}

	@Override
	public void insert(Department d) {
		System.out.println("使用mysql添加一条Department");
	}

	@Override
	public Department getDepartment(String id) {
		System.out.println("使用mysql根据id查询一条Department");
		return d;
	}

}
