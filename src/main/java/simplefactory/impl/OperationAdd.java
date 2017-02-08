package simplefactory.impl;

import simplefactory.JiSuan;
import simplefactory.entiy.Nums;

//加法
public class OperationAdd implements JiSuan {
	public double getSum(Nums n) {
		return n.getNumA()+n.getNumB();
	}

}
