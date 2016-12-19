package decorate.demo;

/*
 	ConcreateComponent是定义的一个具体的对象，实现Component，也可以给这个对象
 	添加一些职责
 */
public class ConcreateComponent implements Component{

	@Override
	public void operation() {
		System.out.println("具体对象的操作");
	}

}
