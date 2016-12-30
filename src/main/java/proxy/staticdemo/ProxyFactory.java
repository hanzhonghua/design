package proxy.staticdemo;

//生成代理类对象
public class ProxyFactory {

	public static Subject  getInstance(){
		return new ProxySubject(new RealSubject());
	}
}
