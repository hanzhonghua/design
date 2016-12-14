package design.stragety.test2;

import design.stragety.test2.impl.CashDisCount;
import design.stragety.test2.impl.CashOriginal;
import design.stragety.test2.impl.CashRebate;

public class CashFatory {

	private static CaseSupper cs;

	//通过构造方法，传入具体收费策略
	public static CaseSupper getAcceptCash(String type) throws Exception{
		switch(type){
			case "正常":
				cs = new CashOriginal();	
				break;
			case "打折":
				cs = new CashDisCount(0.8);
				break;
			case "满减":
				cs = new CashRebate("300", "100");
				break;
		}
		return cs;
	}
}
