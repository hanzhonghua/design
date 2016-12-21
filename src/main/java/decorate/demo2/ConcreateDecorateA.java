package decorate.demo2;

public class ConcreateDecorateA extends Decorator{

	public ConcreateDecorateA(Component compontent) {
		super(compontent);
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("装饰方法A");
	}

}
