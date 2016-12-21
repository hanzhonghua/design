package simplefactory.impl;

import simplefactory.SimpleFactory;
import simplefactory.entiy.Nums;

//减法
public class OperationSub implements SimpleFactory {

	public double getSum(Nums n) {
		return n.getNumA()-n.getNumB();
	}

}
