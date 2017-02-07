package proxy.cglib;

public class Test {

	public static void main(String[] args) {
		CGLIBProxy proxy = new CGLIBProxy();
		CarService cs = (CarService)proxy.getCGLIBProxy(CarService.class);
		cs.addCar();
	}
}
