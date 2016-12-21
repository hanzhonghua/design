package decorate.test3;

import decorate.test3.Clothing;

public class Pants extends Clothing {

	@Override
	public void show() {
		super.show();
		System.out.print("穿牛仔裤");
	}
}
