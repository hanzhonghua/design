package decorate.demo;

//ConcreateDecorator就是具体的装饰对象，起到给Component添加职责的功能
public class ConcreateDecoratorA extends Decorator{

	//独有的功能，用来区别ConcreateDecoratorB
	private String addState;
	
	@Override
	public void operation() {
		//首先运行的是Component的operation
		super.operation();
		//再执行本类功能，addState，相当于对原Component进行装饰
		addState = "new State";
		System.out.print("具体装饰对象A的操作:");
		System.out.println(addState);
	}
}
