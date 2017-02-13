package proxyfactory.different;

//产品接口
interface Producet2{}
//产品实现
class Producet2A implements Producet2{}
class Producet2B implements Producet2{}

//另一个产品接口
interface Producet3{}
//另一个产品实现
class Producet3A implements Producet3{}
class Producet3B implements Producet3{}

//工厂接口，针对原来的工厂方法模式添加了一个方法
interface Factory1{
	Producet2 getProducet2();
	Producet3 getProducet3();
}

//具体工厂A，创建产品A
class Factory1A implements Factory1 {

	@Override
	public Producet2 getProducet2() {
		return new Producet2A();
	}

	@Override
	public Producet3 getProducet3() {
		return new Producet3A();
	}
}

//具体工厂A，创建产品A
class Factory1B implements Factory1 {
	
	@Override
	public Producet2 getProducet2() {
		return new Producet2B();
	}
	
	@Override
	public Producet3 getProducet3() {
		return new Producet3B();
	}
}
public class AbstractFactory {

	//与工厂方法相比，抽象工厂模式多了一个产品接口，工厂接口多了一个方法
	//所以抽象工厂模式就是工厂方法添加了产品接口(抽象产品)演变而来的
	//
	public static void main(String[] args) {
		
		Factory1 f1 = new Factory1A();
		f1.getProducet2();
		f1.getProducet3();
		
		Factory1 f2 = new Factory1B();
		f2.getProducet2();
		f2.getProducet3();
	}
	
}
