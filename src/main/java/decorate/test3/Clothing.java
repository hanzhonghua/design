package decorate.test3;

//服装类Decorator
public class Clothing extends Person{

	protected Person component;
	public void cross(Person component){
		this.component = component;
	}
	@Override
	public void show() {
		if(component != null){
			component.show();
		}
	}
}
