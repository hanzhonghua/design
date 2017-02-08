package factorymethod;

public class TubeCreatorFactory implements Creator {

	@Override
	public Light createLight() {
		return new TubeLight();
	}

}
