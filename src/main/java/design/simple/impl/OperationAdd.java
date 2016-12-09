package design.simple.impl;

import design.simple.SimpleFactory;
import design.simple.entiy.Nums;

//加法
public class OperationAdd implements SimpleFactory {
	public double getSum(Nums n) {
		return n.getNumA()+n.getNumB();
	}

}
