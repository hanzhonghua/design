package proxy.staticdemo;

public class Client {

	public static void main(String[] args) {
		Subject instance = ProxyFactory.getInstance();
		instance.doTask("放羊");
	}
}
