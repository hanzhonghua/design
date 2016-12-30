package stragety.test5;

import stragety.test5.annotation.TotleValidRegion;
import stragety.test5.annotation.ValidRegion;

//普通会员，原价1000以下
@TotleValidRegion(@ValidRegion(max=1000,order=99))
public class CommonPrice implements ReturnPrice{

	public CommonPrice(){
		System.out.println("普通会员，没有优惠");
	}
	@Override
	public double getPrice(double price) {
		return price;
	}

}
