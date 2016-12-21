package decorate.demo2;

public class Client {

	public static void main(String[] args) {
		ConcreateComponent c = new ConcreateComponent();
		ConcreateDecorateA a = new ConcreateDecorateA(c);
		ConcreateDecorateB b = new ConcreateDecorateB(a);
		
		b.show();
	}
}
