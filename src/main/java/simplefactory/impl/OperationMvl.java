package simplefactory.impl;

import simplefactory.SimpleFactory;
import simplefactory.entiy.Nums;

//乘法
public class OperationMvl implements SimpleFactory {

	public double getSum(Nums n) {
		return n.getNumA()*n.getNumB();
	}

}
