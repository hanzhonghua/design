package simple.impl;

import simple.SimpleFactory;
import simple.entiy.Nums;

//乘法
public class OperationMvl implements SimpleFactory {

	public double getSum(Nums n) {
		return n.getNumA()*n.getNumB();
	}

}