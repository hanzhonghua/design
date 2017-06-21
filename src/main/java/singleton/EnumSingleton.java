package singleton;

/*
 * 不管是静态内部类、双重检测都有一个缺点，就是可以使用反射打破单例模式，怎么改进呢？可以使用枚举enum
 * 先来看看如何使用反射打破单例模式
 */
public enum EnumSingleton {

	INSTANCE;
	
	public void print(){
		System.out.println("I am EnumSingleton");
	}
	
}

