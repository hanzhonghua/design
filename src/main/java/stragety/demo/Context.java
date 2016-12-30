package stragety.demo;

//策略模式简单示意
public class Context {

	private Stragety stragety;

	public Context(Stragety stragety) {
		this.stragety = stragety;
	}
	
	public void method(){
		stragety.test();
	}
}
