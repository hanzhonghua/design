package design.stragety.test3;

/**
 * 使用了策略模式
 */
public class Test {

	public static void main(String[] args) {
		try {
			// CashContext cs = new CashContext("正常");
			// CashContext cs = new CashContext("打折");
			 CashContext cs = new CashContext("满减");
			double r = cs.getResult(800);
			System.out.println(r);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
