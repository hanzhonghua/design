package proxyfactory.different;

interface Product{}

class ProductA implements Product{}
class ProductB implements Product{}

public class EasyFactory {

	//这就是简单工厂模式，违背的对修改关闭原则，改成工厂方法
	public Product getProduct(String name){
		if("A".equals(name)){
			return new ProductA();
		}else if("B".equals(name)){
			return new ProductB();
		}
		return null;
	}
}
