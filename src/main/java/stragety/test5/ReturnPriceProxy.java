package stragety.test5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

//相对于test4改变不多，主要添加了一个单词消费判断；还有既是没有直接返回策略实例，而是将满足条件的
//策略条件的信息传给代理，产生一个代理，从而满足代理重叠
public class ReturnPriceProxy implements InvocationHandler{

	private SortedMap<Integer, Class<? extends ReturnPrice>> clazzMap;
	
	public ReturnPriceProxy(SortedMap<Integer, Class<? extends ReturnPrice>> clazzMap) {
		this.clazzMap = clazzMap;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Double result = 0d;
		if(method.getName().equals("getPrice")){
			for (Class<? extends ReturnPrice> clazz : clazzMap.values()) {
				if(result == 0){
					result = (Double) method.invoke(clazz.newInstance(), args);
				}else{
					result = (Double) method.invoke(clazz.newInstance(), result);
				}
			}
			return result;
		}
		return null;
	}

	public static ReturnPrice getProxy(SortedMap<Integer, Class<? extends ReturnPrice>> clazzMap) {
		return (ReturnPrice) Proxy.newProxyInstance(ReturnPrice.class.getClassLoader(),
				new Class<?>[] { ReturnPrice.class }, new ReturnPriceProxy(clazzMap));
	}
}
