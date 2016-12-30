package proxy.test1;

//代理模式之：男孩追女孩，男孩害羞，不好意思亲自给女孩送礼物，然后找proxy给女孩送礼物
//男孩可以给女孩送鲜花，巧克力，洋娃娃。。。
public class Boy {

	Girl mm;
	public Boy(Girl mm){
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
