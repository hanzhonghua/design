package prototype.qiancopy;

//实现Cloneable接口，重写clone方法，即可实现简单的复制
public class PrototypeDemo implements Cloneable {

	private int a;
	private int b;
	private int c;
	
	public PrototypeDemo() {
		this.a = 1;
		this.b = 2;
		this.c = 3;
		System.out.println("加载类");
	}

	public void change(){
		this.a = 4;
		this.b = 5;
		this.c = 6;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object o = null;
		o = super.clone();
		return (PrototypeDemo) o;
	}

	@Override
	public String toString() {
		return "PrototypeDemo [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	public static void main(String[] args) throws Exception {
		PrototypeDemo p1 = new PrototypeDemo();
		p1.change();
		System.out.println(p1);
		Object p2 = p1.clone();
		System.out.println(p2);
		
	}
}
