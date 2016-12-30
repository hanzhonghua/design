package proxy.test3;

public class ProxyFactory {

	public static GiveInterface getInstance(){
		return new Proxy(new Girl("美眉"));
	}
}
