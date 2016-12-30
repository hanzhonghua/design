package stragety.test5;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import stragety.test5.annotation.OnceValidRegion;
import stragety.test5.annotation.TotleValidRegion;
import util.Utils;

//改善后价格策略工厂，使用了自定义注解和反射；
//但是现在还不完美，无法支持重叠：满2000减400，金牌会员再8折；
//此处解决重叠策略
public class PriceFactory {
	
	private final String PRICE_PACKAGE = "design.stragety.test5"; //策略包名
	
	//加载策略时的类加载器，这里的任何类运行信息都必须来自该类加载器
	private ClassLoader classLoader = getClass().getClassLoader();
	
	//策略列表
	private List<Class<? extends ReturnPrice>> priceList;
	
	//根据客户端总金额产生对应的策略
	public ReturnPrice createReturnPrice(Customer customer) throws Exception{
		
		//针对多个优惠活动的优先级别排序，我们使用可排序的Map来存储我们当前策略的运行时信息
		SortedMap<Integer, Class<? extends ReturnPrice>> clazzMap = new TreeMap<>();
		
		//在策略列表中查询策略
		for (Class<? extends ReturnPrice> clazz : priceList) {
			Annotation annotation = Utils.handleAnnotation(clazz);
			//根据注解类型进行不同判断
			if(annotation instanceof TotleValidRegion){
				TotleValidRegion totleValidRegion = (TotleValidRegion)annotation;
				//判断总金额是否在消费区间
				if(customer.getTotlePrice() >= totleValidRegion.value().min() && customer.getTotlePrice() <= totleValidRegion.value().max()){
					//策略放入map
					clazzMap.put(totleValidRegion.value().order(), clazz);
				}
			}else if(annotation instanceof OnceValidRegion){
				OnceValidRegion onceValidRegion = (OnceValidRegion)annotation;
				//判断单词金额是否在注解区间，判断的是客户端当次消费的金额
				if(customer.getPrice() >= onceValidRegion.value().min() && customer.getPrice() <= onceValidRegion.value().max()){
					//策略放入map
					clazzMap.put(onceValidRegion.value().order(), clazz);
				}
			}
			//判断金额是否满足在注解的区间
		}
		try {
			//采用动态代理处理策略重叠问题
			return ReturnPriceProxy.getProxy(clazzMap);
		} catch (Exception e) {
			throw new RuntimeException("策略获取失败");
		}
	}
	
	//单例构造
	private PriceFactory() {
		init();
	}
	
	//工厂初始化时候初始化策略列表
	@SuppressWarnings("unchecked")
	private void init() {
		priceList = new ArrayList<>();
		//获取包下所有class文件
		File[] resources = Utils.getResources(classLoader, PRICE_PACKAGE);
		Class<ReturnPrice> returnPriceClazz = null;
		try {
			//使用相同加载器加载策略接口
			returnPriceClazz = (Class<ReturnPrice>) classLoader.loadClass(ReturnPrice.class.getName());
		} catch (Exception e) {
			throw new RuntimeException("没有找到策略类接口");
		}
		for (int i = 0; i < resources.length; i++) {
			try {
				Class<?> clazz = classLoader.loadClass(PRICE_PACKAGE+"."+resources[i].getName().replace(".class", ""));
				//判断是ReturnPrice的实现而不是本身
				if(ReturnPrice.class.isAssignableFrom(clazz) && clazz != returnPriceClazz){
					priceList.add((Class<? extends ReturnPrice>)clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	//工厂实例
	public static PriceFactory getInstance(){
		return ReturnPriceInstace.instance;
	}
	private static class ReturnPriceInstace{
		private static PriceFactory instance = new PriceFactory();
	}

	//------------------------------------
	
}
