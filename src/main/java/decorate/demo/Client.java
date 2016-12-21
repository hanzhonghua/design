package decorate.demo;

public class Client {

	public static void main(String[] args) {
		ConcreateComponent c = new ConcreateComponent();
		ConcreateDecoratorA a = new ConcreateDecoratorA();
		ConcreateDecoratorB b = new ConcreateDecoratorB();
		
		//装饰方法是：首先用ConcreateComponent的对象c，然后使用ConcreateDecoratorA的
		//对象a来包装c，然后用ConcreateDecoratorB的对象b来包装a，最后调用b的operation()方法
		//通过setComponent来实现装饰对象
		a.setComponent(c);
		b.setComponent(a);
		b.operation();
	}
}
