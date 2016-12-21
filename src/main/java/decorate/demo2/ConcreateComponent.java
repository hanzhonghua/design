package decorate.demo2;

public class ConcreateComponent implements Component {

	@Override
	public void show() {
		System.out.println("需要被装饰的对象");
	}

}
