package stragety.test4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import stragety.test4.annotation.PriceAnnotation;
import util.Utils;

//改善后价格策略工厂，使用了自定义注解和反射；
//但是现在还不完美，无法支持重叠：满2000减400，金牌会员再8折；见test5
public class PriceFactory2 {
	
	private final String PRICE_PACKAGE = "design.stragety.test4"; //策略包名
	
	//加载策略时的类加载器，这里的任何类运行信息都必须来自该类加载器
	private ClassLoader classLoader = getClass().getClassLoader();
	
	//策略列表
	private List<Class<? extends ReturnPrice>> priceList;
	
	//根据客户端总金额产生对应的策略
	public ReturnPrice createReturnPrice(Customer customer) throws Exception{
		//在策略列表中查询策略
		for (Class<? extends ReturnPrice> clazz : priceList) {
			PriceAnnotation priceAnnotation = (PriceAnnotation) Utils.handleAnnotation(clazz);
			//判断金额是否满足在注解的区间
			if(customer.getTotlePrice() >= priceAnnotation.min() && customer.getTotlePrice() <= priceAnnotation.max()){
				//满足的在注解的区间，返回当前策略的一个实例
				try {
					return clazz.newInstance();
				} catch (Exception e) {
					throw new Exception("策略获取失败");
				}
			}
		}
		throw new RuntimeException("策略获取失败");
	}
	
	//单例构造
	private PriceFactory2() {
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
	public static PriceFactory2 getInstance(){
		return ReturnPriceInstace.instance;
	}
	private static class ReturnPriceInstace{
		private static PriceFactory2 instance = new PriceFactory2();
	}

	//------------------------------------
	
}
