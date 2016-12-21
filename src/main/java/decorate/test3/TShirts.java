package decorate.test3;

//装饰类，穿T恤
public class TShirts extends Clothing{

	@Override
	public void show() {
		super.show();
		System.out.print("穿大T恤");
	}

}
