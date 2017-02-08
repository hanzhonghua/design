package factorymethod;

public class BulbLight implements Light{

	@Override
	public void turnOn() {
		System.out.println("BulbLight on");
	}

	@Override
	public void turnOff() {
		System.out.println("BulbLight off");
	}

}
