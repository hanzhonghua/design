package decorate.test3;

import decorate.test3.Clothing;

public class Suit extends Clothing {

	@Override
	public void show() {
		super.show();
		System.out.print("穿西装");
	}

}
