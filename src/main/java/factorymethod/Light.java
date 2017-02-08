package factorymethod;

/**
 * 在简单工厂中：操作都是在工厂类中完成的，如果需要增加一个操作的话，就需要修改工厂类
 * 这就违背类开闭原则，既是对修改关闭，对扩展开放，如果以后操作增加的话，都在一个类中
 * 操作，会造成类过于庞大，后期不容易维护，这就出现了工厂方法模式：
 * 定义一个用于创建对象的接口，让子类决定实例化那一个类，工厂方法是一个类的实例化延迟到
 * 其子类
 */
public interface Light {

	public void turnOn();
	public void turnOff();
}
