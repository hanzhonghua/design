package proxy.customjdk;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;


/**
 * JDK动态代理是通过Proxy的newProxyInstance方法生成代理对象的，下面将自定义一个MyProxy类模拟Proxy实现动态创建代理对象
 * 该类有一静态方法可以动态的为实现了某一/些接口(或本身就是接口)任意类的任一方法产生任意代理对象
 * 实现思路：首先需要声明一段源码，可以动态的生成代理类，然后使用JDK Compiler API编译该源码，生成一个新的类，
 * 然后将该类加载的内存中，产生一个新的对象，该对象既是我们需要的代理对象，最后返回改对象即可。
 */
public class MyProxy {

	public static Object newProxyInstance(Class<?> interfaces,MyInvocationHandler h) throws Exception{
		//Windows下的换行符号
		String wrap = "\r\n";
		String method = "";
		for(Method m:interfaces.getMethods()){
			method +="	@Override"+ wrap +
					 "	public void "+m.getName()+"() {"+ wrap +
					 "  try{" + wrap +
					 "  Method md = " +interfaces.getName() +".class.getMethod(\""+m.getName()+"\");" +wrap +
					 " 	h.invoke(this,md);"+ wrap +
					 "  }catch(Exception e){e.printStackTrace();}" + wrap +
					 "	}"+ wrap ;
		}
		//声明一段源码
		String source = 
			"package proxy.customjdk;"+ wrap +
			
			"import java.lang.reflect.Method;" +wrap +
			"import proxy.customjdk.MyInvocationHandler;"+ wrap +
			"public class $Proxy0 implements " + interfaces.getName() + "{"+ wrap +
			
			"	private MyInvocationHandler h;"+ wrap +
			"	public $Proxy0(MyInvocationHandler h) {"+ wrap +
			"		this.h = h;"+ wrap +
			"	}"+ wrap +
			method+
			"}";

		
		//编译以上源码，需要生成一个Java文件，对该文件进行编译
		//定义文件路径，当前包下
		String fileName = System.getProperty("user.dir") +"/src/main/java/proxy/customjdk/$Proxy0.java";
		File file = new File(fileName);
		FileUtils.writeStringToFile(file, source);
		
		//编译
		//得到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理者
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable jfile = fileManager.getJavaFileObjects(fileName);
		//编译任务
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, jfile);
		task.call();
		fileManager.close();
		
		//加载到内存
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		//使用指定的二进制名称加载类
		Class c = loader.loadClass("proxy.customjdk.$Proxy0");
		//获取构造方法反射对象
		Constructor constructor = c.getConstructor(MyInvocationHandler.class);
		//创建类的实例并返回
		return constructor.newInstance(h);
	}
}
