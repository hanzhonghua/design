package stragety.test5;

import stragety.test5.annotation.TotleValidRegion;
import stragety.test5.annotation.ValidRegion;

//超级会员3000以上，7折
@TotleValidRegion(@ValidRegion(min=3000,order=99))
public class SuperPrice implements ReturnPrice{
	public SuperPrice(){
		System.out.println("超级会员，享受7折优惠");
	};
	@Override
	public double getPrice(double price) {
		return price*0.7;
	}

}
