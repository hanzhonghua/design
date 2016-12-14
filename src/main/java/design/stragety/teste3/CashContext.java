package design.stragety.teste3;

import design.stragety.teste3.impl.CashDisCount;
import design.stragety.teste3.impl.CashOriginal;
import design.stragety.teste3.impl.CashRebate;

/**
	策略模式具体实现：维护一个父类顶层对象的引用；
	与简单工厂结合，将原来实例化具体收费的策略放到改类中；
	与test2的简单工厂实现区别：在简单工厂中，客户端需要知道两个类：CaseSupper、CashFactory,
	而策略模式中将与算法相关的具体策略封装到一个类中，诠释了"高内聚,低耦合",调用CashContext
	的构造方法根据传递不同的收费类型创建对应的收费类的对象，调用getResult(x)方法计算价格，
	具体的收费算法与客户端分离，就连父类CaseSupper客户端也不会认识
	
	但是：现在的代码任然不完美，比如：增加一个收费类型，还需要修改switch，具体修改：使用反射！
	具体实现请见抽象工厂模式！
 */
public class CashContext {

	private CaseSupper cs;

	//通过构造方法，传入具体收费策略(收费类型)	
	public CashContext(String type) throws Exception {
		//TODO 使用反射改进switch
		switch(type){
		case "正常":
			CashOriginal co = new CashOriginal();	
			cs = co;
			break;
		case "打折":
			CashDisCount cd = new CashDisCount(0.8);
			cs = cd;
			break;
		case "满减":
			CashRebate cr = new CashRebate("300", "100");
			cs = cr;
			break;
		}
	}
	
	public double getResult(double money){
		//根据收费策略不同，返回收费结果
		return cs.acceptCash(money);
	}
}
