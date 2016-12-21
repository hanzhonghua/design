package simplefactory.impl;

import simplefactory.SimpleFactory;
import simplefactory.entiy.Nums;

//加法
public class OperationAdd implements SimpleFactory {
	public double getSum(Nums n) {
		return n.getNumA()+n.getNumB();
	}

}
