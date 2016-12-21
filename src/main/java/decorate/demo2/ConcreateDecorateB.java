package decorate.demo2;

public class ConcreateDecorateB extends Decorator{

	public ConcreateDecorateB(Component compontent) {
		super(compontent);
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("装饰方法B");
	}

}
