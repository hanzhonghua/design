package design.stragety.test4;

import design.stragety.test4.annotation.PriceAnnotation;

//超级会员3000以上，7折
@PriceAnnotation(min=3000)
public class SuperPrice implements ReturnPrice{
	public SuperPrice(){
		System.out.println("超级会员，享受7折优惠");
	};
	@Override
	public double getPrice(double price) {
		return price*0.7;
	}

}
