package stragety.test5;

import stragety.test5.annotation.OnceValidRegion;
import stragety.test5.annotation.ValidRegion;

//第二种算法策略：满2000减500
@OnceValidRegion(@ValidRegion(min=2000,order=40))
public class Two implements ReturnPrice{

	@Override
	public double getPrice(double price) {
		System.out.println("满2000减500");
		return price-500;
	}

}