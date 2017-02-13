package proxyfactory.demo;

public class UserService {
	
	private User u;
	
	public UserService(User u) {
		this.u = u;
	}
	public void insert(User user){
		System.out.println("在mysql中添加一个user");
	}
	public User getUser(String id){
		System.out.println("在mysql通过id查询一个user");
		return u;
	}
}
