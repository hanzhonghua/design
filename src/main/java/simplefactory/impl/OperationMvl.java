package simplefactory.impl;

import simplefactory.JiSuan;
import simplefactory.entiy.Nums;

//乘法
public class OperationMvl implements JiSuan {

	public double getSum(Nums n) {
		return n.getNumA()*n.getNumB();
	}

}
