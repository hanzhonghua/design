package stragety.test4;

//价格策略工厂
public class PriceFactory {
	
	private static ReturnPrice rp;

	//买东西，确认那个价格策略，需要根据策略不同使用使用elseif确定使用那一个策略，增加一个策略时候，还要在添加一个elseif
	//如何改进？使用反射，确定策略类，对于价格区间的选择我们使用自定义注解(给注解属性加入上下限)
	public static ReturnPrice returnPrice(Customer c) {
		if(c.getTotlePrice()>3000){
			rp = new SuperPrice();
		}else if(c.getTotlePrice()>2000){
			rp = new GoldPrice();
		}else if(c.getTotlePrice()>1000){
			rp = new SilverPrice();
		}else{
			rp = new CommonPrice();
		}
		return rp;
	}
}
