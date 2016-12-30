package stragety.test4;

//客户端调用
public class Client {

	public static void main(String[] args) {
		Customer c = new Customer();
		c.buy(2000);
		System.out.println("原价："+2000);
		double price = c.getLastPrice();
		System.out.println("应付"+price);
		
		Customer c1 = new Customer();
		c1.buy(4000);
		System.out.println("原价："+4000);
		double price1 = c1.getLastPrice();
		System.out.println("应付"+price1);
		
		Customer c2 = new Customer();
		c2.buy(1200);
		System.out.println("原价："+1200);
		double price2 = c2.getLastPrice();
		System.out.println("应付"+price2);
		
		Customer c3 = new Customer();
		c3.buy(200);
		System.out.println("原价："+200);
		double price3 = c3.getLastPrice();
		System.out.println("应付"+price3);
	}
}
