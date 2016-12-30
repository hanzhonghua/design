package proxy.test3;

//代理类改变一下：有一boy变量，通过构造方法接受Gril类型参数，在构造方法中new Boy(mm),通过得到的对象赋值给boy
//变量，在送礼物的各个方法中调用boy的对应方法,
//要求代理类和被代理类(简称委托类)实现统一接口或父类，在代理类中需要保存一个引用指向委托类，并提供一个与父类相同的接口，
//以便可以替换委托类，这种需要手动写代理类源码然后编译的成为静态代理：就是在程序运行前已经存在代理类的字节码文件，
//代理类和委托类的关系在运行前已经确定了，看staticdemo
public class Proxy implements GiveInterface {
	Boy boy;
	public Proxy(Girl mm){
		boy = new Boy(mm);
	}
	@Override
	public void giveFlows() {
		boy.giveFlows();
	}
	@Override
	public void giveChocolate() {
		boy.giveChocolate();
	}
	@Override
	public void giveDolls() {
		boy.giveDolls();
	}
}
