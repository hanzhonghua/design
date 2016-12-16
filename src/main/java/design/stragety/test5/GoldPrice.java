package design.stragety.test5;

import design.stragety.test5.annotation.TotleValidRegion;
import design.stragety.test5.annotation.ValidRegion;

//金牌会员，花费2000-3000，享受8折
@TotleValidRegion(@ValidRegion(max=3000,min=2000,order=99))
public class GoldPrice implements ReturnPrice{
	public GoldPrice(){
		System.out.println("金牌会员，享受8折优惠");
	}
	@Override
	public double getPrice(double price) {
		return price*0.8;
	}

}
