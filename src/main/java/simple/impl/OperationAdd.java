package simple.impl;

import simple.SimpleFactory;
import simple.entiy.Nums;

//加法
public class OperationAdd implements SimpleFactory {
	public double getSum(Nums n) {
		return n.getNumA()+n.getNumB();
	}

}
