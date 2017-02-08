package factorymethod;

public class BulbCreatorFactory implements Creator {

	@Override
	public Light createLight() {
		return new BulbLight();
	}

}
