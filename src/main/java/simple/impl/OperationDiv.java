package simple.impl;

import simple.SimpleFactory;
import simple.entiy.Nums;

//除法
public class OperationDiv implements SimpleFactory {

	public double getSum(Nums n) throws Exception {
		if(n.getNumB() != 0){
			return n.getNumA()/n.getNumB();
		}else{
			throw new Exception("除数不能为0");
		}
	}

}
