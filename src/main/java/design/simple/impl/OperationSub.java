package design.simple.impl;

import design.simple.SimpleFactory;
import design.simple.entiy.Nums;

//减法
public class OperationSub implements SimpleFactory {

	public double getSum(Nums n) {
		return n.getNumA()-n.getNumB();
	}

}
