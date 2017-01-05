package factorymethod.typeinfo;

import java.lang.reflect.Constructor;

class Base{}

class Drived extends Base{
	Drived(){};
}

public class FamilyVsExacType {
	static void test(Object o){
		System.out.println("Testing o of type:"+o.getClass());
		System.out.println("o instanceof Base:"+(o instanceof Base));
		System.out.println("o instanceof Drived:"+(o instanceof Drived));
		System.out.println("Base.isInstance(o):"+Base.class.isInstance(o));
		System.out.println("Drived.isInstance(o):"+Drived.class.isInstance(o));
		System.out.println("o.getClass()==Base.class:"+(o.getClass()==Base.class));
		System.out.println("o.getClass()==Drived.class:"+(o.getClass()==Drived.class));
		System.out.println("o.getClass().equals(Base.class):"+o.getClass().equals(Base.class));
		System.out.println("o.getClass().equals(Drived.class):"+o.getClass().equals(Drived.class));
	}
	
	//测试Class文件和instanceof等价性，
	public static void main(String[] args) throws Exception {
		test(new Base());
		System.out.println("------------------------------------");
		test(new Drived());
		Class<?> c = Class.forName("factorymethod.typeinfo.Drived");
		Constructor<?>[] ccc = c.getDeclaredConstructors();
		for (Constructor<?> constructor : ccc) {
			System.out.println(constructor);
		}
	}
}
