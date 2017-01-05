package proxy.reflect.test1;

/**
	一个类初始化时机：
		调用类的静态成员(注意如果静态成员被final修饰，调用时类是不会被初始化的)：因为static final是编译器常量，不需要对类
			初始化即可读取
		Class.forName("xx")
		new 
		初始化类的子类时
 */
class Initable{
	static final int a =177;
	static{
		System.out.println("Initialing Initable");
	}
}

class Initable2{
	static int a =188;
	static{
		System.out.println("Initialing Initable2");
	}
}
class Initable3{
	static int a =199;
	static{
		System.out.println("Initialing Initable3");
	}
}

public class TestClassLoader2{
	public static void main(String[] args) {
		Class<Integer> type3 = int.class;
		Class<Integer> type = Integer.TYPE;
		Class<Integer> type2 = Integer.class;
		System.out.println(type == type2);
		System.out.println(type3 == type2);
		System.out.println(type3 == type);
		System.out.println(Initable.a);
		System.out.println(Initable2.a);
		try {
			Class.forName("proxy.reflect.test1.Initable3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}