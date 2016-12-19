package decorate.test2.impl;

import decorate.test2.Clothing;

public class Suit implements Clothing {

	@Override
	public void cross() {
		System.out.print("穿西装");
	}

}
