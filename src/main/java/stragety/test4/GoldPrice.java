package stragety.test4;

import stragety.test4.annotation.PriceAnnotation;

//金牌会员，花费2000-3000，享受8折
@PriceAnnotation(min=2000,max=3000)
public class GoldPrice implements ReturnPrice{
	public GoldPrice(){
		System.out.println("金牌会员，享受8折优惠");
	}
	@Override
	public double getPrice(double price) {
		return price*0.8;
	}

}
