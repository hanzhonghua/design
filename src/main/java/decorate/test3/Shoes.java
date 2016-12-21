package decorate.test3;

import decorate.test3.Clothing;

public class Shoes extends Clothing {

	@Override
	public void show() {
		super.show();
		System.out.print("穿运动鞋");
	}
}
