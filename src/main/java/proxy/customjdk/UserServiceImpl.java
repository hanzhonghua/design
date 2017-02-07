package proxy.customjdk;

//操作用户信息实现类
public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("添加一个用户");
	}

	@Override
	public void delete() {
		System.out.println("删除一个用户");
	}

}
