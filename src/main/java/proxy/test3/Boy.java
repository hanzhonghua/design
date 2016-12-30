package proxy.test3;

//Boy类不用改变
public class Boy implements GiveInterface {
	Girl mm;
	public Boy(Girl mm) {
		this.mm = mm;
	}
	// 送鲜花
	@Override
	public void giveFlows() {
		System.out.println(mm.getName() + "送你鲜花");
	}
	// 送巧克力
	@Override
	public void giveChocolate() {
		System.out.println(mm.getName() + "送你巧克力");
	}
	// 送洋娃娃
	@Override
	public void giveDolls() {
		System.out.println(mm.getName() + "送你洋娃娃");
	}
}
