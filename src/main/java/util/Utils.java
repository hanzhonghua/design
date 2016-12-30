package util;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;

public class Utils {

	//判断是否是double类型
	public static boolean isDouble(String value){
		try {
			Double.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	//处理注解，传入一个策略类，返回它的注解
	public static <T> Annotation handleAnnotation(Class<? extends T> clazz){
		Annotation[] annotations = clazz.getDeclaredAnnotations();
		if(annotations == null || annotations.length == 0){
			return null;
		}
		for (int i = 0; i < annotations.length; i++) {
			if(annotations[i] instanceof Object){
				return  annotations[i];
			}
		}
		return null;
	}
	//获取扫描包下的所有class文件
	public static File[] getResources(ClassLoader classLoader,String packages) {
		try {
			File file = new File(classLoader.getResource(packages.replace(".", "/")).toURI());
			return file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					//只扫描class文件
					if(pathname.getName().endsWith(".class"))
						return true;
					return false;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
