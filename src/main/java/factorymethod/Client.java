package factorymethod;

public class Client {

	public static void main(String[] args) {
		Creator factory = new BulbCreatorFactory();
		Light light = factory.createLight();
		light.turnOn();
		light.turnOff();
		
		factory = new TubeCreatorFactory();
		light = factory.createLight();
		light.turnOn();
		light.turnOff();
	}
}
