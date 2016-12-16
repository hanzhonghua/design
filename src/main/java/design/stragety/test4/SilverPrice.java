package design.stragety.test4;

import design.stragety.test4.annotation.PriceAnnotation;

//银牌会员1000-2000。9折
@PriceAnnotation(min=1000,max=2000)
public class SilverPrice implements ReturnPrice{

	public SilverPrice(){
		System.out.println("银牌会员，享受9折优惠");
	}
	@Override
	public double getPrice(double price) {
		return price*0.9;
	}

}
