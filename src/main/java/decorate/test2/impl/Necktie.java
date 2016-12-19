package decorate.test2.impl;

import decorate.test2.Clothing;

public class Necktie implements Clothing {

	@Override
	public void cross() {
		System.out.print("打领带");
	}

}
