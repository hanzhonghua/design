package simple;

import simple.impl.OperationAdd;
import simple.impl.OperationDiv;
import simple.impl.OperationMvl;
import simple.impl.OperationSub;

//运算方法
public class Operation {
	
	public static SimpleFactory operation(String operation){
		SimpleFactory factory = null;
		switch(operation){
			case "+":
				factory = new OperationAdd();
				break;
			case "-":
				factory = new OperationSub();
				break;
			case "*":
				factory = new OperationMvl();
				break;
			case "/":
				factory = new OperationDiv();
				break;
		}
		return factory;
	}
}
