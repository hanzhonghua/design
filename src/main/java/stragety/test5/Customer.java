package stragety.test5;

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
			rp = PriceFactory.getInstance().createReturnPrice(this);
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
