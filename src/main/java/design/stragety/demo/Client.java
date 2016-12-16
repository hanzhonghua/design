package design.stragety.demo;

public class Client {

	public static void main(String[] args) {
		Context c = new Context(new ConcreteStragetyA());
		c.method();
		c = new Context(new ConcreteStragetyB());
		c.method();
		c = new Context(new ConcreteStragetyC());
		c.method();
	}
}
