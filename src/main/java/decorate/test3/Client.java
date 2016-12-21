package decorate.test3;

public class Client {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("小韩");
		TShirts t = new TShirts();
		Pants pants = new Pants();
		Shoes shoes = new Shoes();
		
		t.cross(p);
		pants.cross(t);
		shoes.cross(pants);
		shoes.show();
		
		System.out.println();
		Suit suit = new Suit();
		Necktie necktie = new Necktie();
		LeatherShoes l = new LeatherShoes();
		suit.cross(p);
		necktie.cross(suit);
		l.cross(necktie);
		l.show();
	}
}
