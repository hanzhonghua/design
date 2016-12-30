package proxy.test2;

//此时代理有了，但是没有了Boy，只是把Boy换成了Proxy，而真实情况事boy、proxy都存在的，礼物是boy
//买的，只是是proxy代送的，见test3
public class Client {

	public static void main(String[] args) {
		Girl mm = new Girl();
		mm.setName("美眉");
		Proxy b = new Proxy(mm);
		b.giveChocolate();
		b.giveDolls();
		b.giveFlows();
	}
}
