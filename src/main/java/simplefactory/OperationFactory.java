package simplefactory;

import simplefactory.impl.OperationAdd;
import simplefactory.impl.OperationDiv;
import simplefactory.impl.OperationMvl;
import simplefactory.impl.OperationSub;

public class OperationFactory {
	
	public static JiSuan operation(String operation){
		JiSuan factory = null;
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
