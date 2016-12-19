package simple.impl;

import simple.SimpleFactory;
import simple.entiy.Nums;

//减法
public class OperationSub implements SimpleFactory {

	public double getSum(Nums n) {
		return n.getNumA()-n.getNumB();
	}

}
