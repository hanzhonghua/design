package proxy.reflect.test1;

class Candy {
	// 静态代码块在类首次加载时运行，并且只运行一次
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static int a;
	static {
		System.out.println("Loading Cookie");
	}
}

// 一个类是在第一次被使用时，动态加载到jvm的，当程序创建第一个对类的静态引用时，
// 就会加载这个类，所有构造方法也是类的静态方法
public class TestClassLoader {

	public static void main(String[] args) {
		if(boolean.class == Boolean.TYPE){
			System.out.println("哈哈哈");
		}
		new Candy();
		try {
			// 返回给定字符串名称的接口或类的相关对象
			Class.forName("proxy.reflect.Gum");
		} catch (Exception e) {
			System.out.println("Can not find Gum");
		}
		// 当程序创建第一个对类的静态引用时，就会加载这个类
		System.out.println(Cookie.a);
	}
}
