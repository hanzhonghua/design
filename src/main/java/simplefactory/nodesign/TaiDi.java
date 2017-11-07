package simplefactory.nodesign;

public class TaiDi extends Animal {

	public TaiDi() {
		System.out.println("出售一条泰迪");
	}

	@Override
	public void sleep() {
		System.out.println("泰迪在睡觉");
	}
	@Override
	public void eat() {
		System.out.println("泰迪在吃食物");
	}
}
