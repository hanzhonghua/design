package decorate.test1;
/*
    屌丝程序员不同的装扮，一个是打球状态，一个是职场状态引出设计模式之：装饰模式
    但是现在需要添加一个状态：超人状态，直接在Person类添加？不不不，刚刚学到了开闭原则
    我们应该遵循，不要修改原有代码，在现有代码上增加一些新的实现，我们做一个服装接口，有
    各种服饰的子类：面向接口编程。见test2
*/
public class Person {

	private String name ;
	public void setName(String name){
		this.name = name;
	}
	public void crossTShirts(){
		System.out.print("穿大T恤");
	}
	public void crossPants(){
		System.out.print("穿垮裤");
	}
	public void crossShoes(){
		System.out.print("穿破球鞋");
	}
	
	public void crossSuit(){
		System.out.print("穿西装");
	}
	public void crossNecktie(){
		System.out.print("打领带");
	}
	public void crossLeatherShoes(){
		System.out.print("穿皮鞋");
	}
	
	public void show(){
		System.out.print("屌丝程序猿"+name);
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("小韩");
		p.show();
		p.crossTShirts();
		p.crossPants();
		p.crossShoes();
		System.out.println();
		Person p2 = new Person();
		p2.setName("老韩");
		p2.show();
		p2.crossSuit();
		p2.crossNecktie();
		p2.crossLeatherShoes();
	}
}
