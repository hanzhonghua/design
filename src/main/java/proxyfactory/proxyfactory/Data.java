package proxyfactory.proxyfactory;

public class Data {

	//不同的数据库连接
	private static final String db = "mysql";
	//private static final String db = "oracle";
	
	/**
	 * 系统之中不可以就几个表，另外数据库连接也有可能编程sqlserver
	 * 此时我们使用反射来优化Data
	 */
	//user的mysql和oracle
	public static UserService createUser(){
		if("mysql".equals(db)){
			return new MysqlUserServiceImpl();
		}else if("oracle".equals(db)){
			return new OracleUserServiceImpl();
		}
		return null;
	}
	
	//department的mysql和oracle
	public static IDepartment createDepartment(){
		if("mysql".equals(db)){
			return new MysqlDepartmentImpl();
		}else if("oracle".equals(db)){
			return new OracleDepartmentImpl();
		}
		return null;
	}
}
