package singleton.enumt;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

public class Reflection {

	public static Set<String> analyze(Class<?> enumClass){
		System.out.println("Analyzing " + enumClass + "----");
		Type[] types = enumClass.getGenericInterfaces();
		for (Type type : types) {
			System.out.println(type);
		}
		Set<String> set = new TreeSet<>();
		for(Method m : enumClass.getDeclaredMethods()){
			set.add(m.getName());
		}
		System.out.println(set);
		return set;
	}
	
	public static void main(String[] args) {
		analyze(Enum.class);
	}
	
}
