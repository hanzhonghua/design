package decorate.demo;

//ConcreateDecorator就是具体的装饰对象，起到给Component添加职责的功能
public class ConcreateDecoratorB extends Decorator{

	@Override
	public void operation() {
		//首先运行的是Component的operation
		super.operation();
		System.out.print("具体装饰对象B的操作");
		test();
	}
	
	private void test(){
		System.out.println("B类装饰");
	}
}
