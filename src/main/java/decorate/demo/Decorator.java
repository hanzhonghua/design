package decorate.demo;

/*
	Decorator装饰抽象类，实现类Component接口，从外类来扩展Component类的功能
	但是对于Component来说，是不知道Decorator的存在的
 */
public class Decorator implements Component{

	protected Component component;

	public void setComponent(Component component) {
		this.component = component;
	}

	@Override
	public void operation() {
		if(component != null){
			component.operation();
		}
	}

}
