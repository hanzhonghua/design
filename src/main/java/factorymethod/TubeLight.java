package factorymethod;

public class TubeLight implements Light {

	@Override
	public void turnOn() {
		System.out.println("TubeLight on");
	}

	@Override
	public void turnOff() {
		System.out.println("TubeLight off");
	}

}
