package design.stragety.test4;

import design.stragety.test4.annotation.PriceAnnotation;

//普通会员，原价1000以下
@PriceAnnotation(max=1000)
public class CommonPrice implements ReturnPrice{

	public CommonPrice(){
		System.out.println("普通会员，没有优惠");
	}
	@Override
	public double getPrice(double price) {
		return price;
	}

}
