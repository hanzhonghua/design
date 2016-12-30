package proxy.test1;

//boy亲自给mm送礼物，有以下问题：mm是不认识boy的，而new Boy(mm)表示两者互相认识
//此时引入"第三者"代理proxy，请看test2
public class Client {

	public static void main(String[] args) {
		Girl mm = new Girl();
		mm.setName("美眉");
		Boy b = new Boy(mm);
		b.giveChocolate();
		b.giveDolls();
		b.giveFlows();
	}
}
