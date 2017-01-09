package proxy.reflect.dbdemo;

//反射用处很多，其实就是帮我们做哪些重复的有柜规则的事情
//例如：mybatis 。。逆向工程，aop原理是动态代理，而动态代理底层就是反射
public class Test {

	public static void main(String[] args) {
		DAOUtil session = new DAOUtil();
		Student student = new Student();
		student.setId("1");
		student.setName("小明");
		student.setAge(18);
		student.setGrade(100d);
		//保存
		String sql = session.getSql(student);
		System.out.println("保存对象的sql："+sql);
		//查询
		Student s = (Student)session.getObject("proxy.reflect.dbdemo.Student", "1");
		System.out.println("获取的信息："+s);
	}
}
