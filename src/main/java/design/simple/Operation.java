package design.simple;

import design.simple.impl.OperationAdd;
import design.simple.impl.OperationDiv;
import design.simple.impl.OperationMvl;
import design.simple.impl.OperationSub;

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
