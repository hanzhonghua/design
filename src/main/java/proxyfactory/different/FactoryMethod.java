package proxyfactory.different;

//产品接口
interface Product1{}
//产品具体实现
class Product1A implements Product1{}
class Product1B implements Product1{}

//工厂接口
interface Factory{}
//工厂具体实现A,创建具体产品A
class FactoryA implements Factory{
	public Product1 getProduct(){
		return new Product1A();
	}
}
//工厂具体实现B,创建具体产品B
class FactoryB implements Factory{
	public Product1 getProduct(){
		return new Product1B();
	}
}

//只是将简单工厂的工厂抽象成接口，并给相应产品添加相应的工厂类，就成了工厂方法模式
//在看看工厂方法模式如何转化成抽象工厂模式
public class FactoryMethod {

	Factory f1 = new FactoryA();
	Factory f2 = new FactoryB();
}
