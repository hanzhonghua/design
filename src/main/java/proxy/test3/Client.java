package proxy.test3;

//我们先来分析一下代理类和boy，发现他们拥有相同的方法，可以写一个接口，有送礼物的方法，
//让proxy和boy实现该接口；
public class Client {

	public static void main(String[] args) {
		//GiveInterface p = ProxyFactory.getInstance();
		Proxy p = new Proxy(new Girl("丽丽"));
		p.giveChocolate();
		p.giveDolls();
		p.giveFlows();
	}
}
