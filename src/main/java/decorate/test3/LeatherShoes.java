package decorate.test3;

import decorate.test3.Clothing;

public class LeatherShoes extends Clothing {

	@Override
	public void show() {
		super.show();
		System.out.print("穿皮鞋");
	}	

}
