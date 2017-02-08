package simplefactory.impl;

import simplefactory.JiSuan;
import simplefactory.entiy.Nums;

//减法
public class OperationSub implements JiSuan {

	public double getSum(Nums n) {
		return n.getNumA()-n.getNumB();
	}

}
