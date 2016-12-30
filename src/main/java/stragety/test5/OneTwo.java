package stragety.test5;

import stragety.test5.annotation.OnceValidRegion;
import stragety.test5.annotation.ValidRegion;

//第二种算法策略：满1000减200
@OnceValidRegion(@ValidRegion(min=1000,order=40))
public class OneTwo implements ReturnPrice{

	@Override
	public double getPrice(double price) {
		System.out.println("满1000减200");
		return price-200;
	}

}
