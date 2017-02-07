package proxy.reflect.purpose;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//反射避开范型检查：通过源码发现范型是在程序编译期间检查的，通过反射拿到程序中类运行时的对象
public class ReflectDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//泛型简写，Java7之后出现的
		List<Integer> list = new ArrayList<>();
		Class c = list.getClass();
		try {
			//通过class对象得到方法名为add参数类型是Object的方法对象
			Method method = c.getMethod("add",Object.class);
			//调用list的method方法传参""小明，相当于：list.add("小明");
			method.invoke(list, "小明");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
