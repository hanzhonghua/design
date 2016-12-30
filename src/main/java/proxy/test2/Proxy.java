package proxy.test2;

//代理，代理男孩送礼物
public class Proxy {

	Girl mm;
	public Proxy(Girl mm){
		this.mm=mm;
	}
	
	//送鲜花
	public void giveFlows(){
		System.out.println("送给："+mm.getName()+"一朵鲜花");
	}
	//送巧克力
	public void giveChocolate(){
		System.out.println("送给："+mm.getName()+"一块巧克力");
	}
	//送洋娃娃
	public void giveDolls(){
		System.out.println("送给："+mm.getName()+"一个洋娃娃");
	}
}
