package decorate.demo;

/*
 	装饰模式：可以动态的给对象添加职责
 	Component是定义了一个对象的接口，可以给这些对象动态添加职责
 */
public interface Component {

	public abstract void operation();
}
