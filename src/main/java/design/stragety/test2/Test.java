package design.stragety.test2;

public class Test {

	public static void main(String[] args) {
		/*CaseSupper cash = CashFactory.getAcceptCash("正常");
		double d = cash.acceptCash(100);
		System.out.println(d);*/
		/*CaseSupper cash = CashFactory.getAcceptCash("打折");
		double d = cash.acceptCash(100);
		System.out.println(d);*/
		try {
			CaseSupper cs = CashFatory.getAcceptCash("满减");
			double r = cs.acceptCash(800);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
