package design.stragety.test5;

import design.stragety.test5.annotation.OnceValidRegion;
import design.stragety.test5.annotation.ValidRegion;

//第二种算法策略：满2000减500
@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class Two implements ReturnPrice{

	@Override
	public double getPrice(double price) {
		return price-500;
	}

}