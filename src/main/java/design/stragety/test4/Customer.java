package design.stragety.test4;

//客户类
public class Customer {
	
	//总价格
	private double totlePrice = 0;
	//单词消费价格
	private double price = 0;
	private ReturnPrice rp ;

	public void buy(double price){
		this.price = price;
		totlePrice += price;
		//rp = PriceFactory.returnPrice(this);
		try {
			//改善后的策略工厂，使用了自定义注解和反射；
			//但是现在还不完美，无法支持重叠：满2000减400，金牌会员再8折；见test5
			rp = PriceFactory2.getInstance().createReturnPrice(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//得出用户花费多少钱
	public double getLastPrice(){
		return rp.getPrice(totlePrice);
	}

	public double getPrice() {
		return price;
	}
	public double getTotlePrice() {
		return totlePrice;
	}
	
}
