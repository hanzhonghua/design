package proxy.reflect.test1;

interface HahBatteries {
}

interface WaterPoor {
}

interface Shoots {
}

class Toy {
	//Toy() {};

	Toy(int a) {};
}

class ToyFancy extends Toy implements HahBatteries, WaterPoor, Shoots {
	ToyFancy() {
		super(1);
	}
}

@SuppressWarnings("rawtypes")
public class TestToy {

	static void printInto(Class cc) {
		System.out.println("Class name:" + cc.getName()  + " is interface?[" + cc.isInterface() + "]\n"
				+ "Simple name:" + cc.getSimpleName() + "\n" + "Canonical name:" + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c = null;
		try {
			//c = Class.forName("proxy.reflect.test1.ToyFancy");
			c = ToyFancy.class;
		} catch (Exception e) {
			System.out.println("Can not find ToyFancy");
			System.out.println(e.toString());
			System.exit(1);
		}
		printInto(c);
		for (Class f : c.getInterfaces()) {
			printInto(f);
		}
		Class sc = c.getSuperclass();
		Object o = null;
		try {
			o = sc.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Can not instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Can not access");
			System.exit(1);
		}
		printInto(o.getClass());
	}
}
