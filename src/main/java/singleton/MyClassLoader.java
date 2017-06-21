package singleton;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;


public class MyClassLoader extends ClassLoader {

	private String name; // 类加载器的名字
	private String path = "e://"; //加载类的路径
	private final String fileType = ".class";
	
	public MyClassLoader(String name) {
		super(); //让系统加载器成为该类的加载器的父类加载器
		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name) {
		super(parent); //显示指定该类加载器的父类 加载器
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @Title: loadClassData
	 * @Description: 读取class文件作为二进制流放到byte中去
	 * @param name
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private byte[] loadClassData(String name){
		InputStream in = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		
		try {
			name = name.replace(".", "\\");
			in = new BufferedInputStream(new FileInputStream(new File(path + name +fileType)));
			baos = new ByteArrayOutputStream();
			int ch = 0;
			while(-1 != (ch = in.read())){
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	// JVM调用的加载器方法
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}
	
	public static Object create(ClassLoader loader,String name) throws Exception{
		Class<?> clazz = loader.loadClass(name);
		return clazz.newInstance();
	}
	
	public static void main(String[] args) {
		MyClassLoader loader = new MyClassLoader("myLoader");
		loader.setPath("e://");
		try {
			LazySingleton create = (LazySingleton) create(loader, "singleton.LazySingleton");
			System.out.println(create);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
