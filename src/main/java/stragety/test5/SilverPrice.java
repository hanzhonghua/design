package stragety.test5;

import stragety.test5.annotation.TotleValidRegion;
import stragety.test5.annotation.ValidRegion;

//银牌会员1000-2000。9折
@TotleValidRegion(@ValidRegion(min=1000,max=2000,order=99))
public class SilverPrice implements ReturnPrice{

	public SilverPrice(){
		System.out.println("银牌会员，享受9折优惠");
	}
	@Override
	public double getPrice(double price) {
		return price*0.9;
	}

}
