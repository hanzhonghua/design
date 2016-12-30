package stragety.test2.impl;

import stragety.test2.CaseSupper;

//打折
public class CashDisCount implements CaseSupper{

	private double disCount = 1;
	
	public CashDisCount(double disCount) {
		this.disCount = disCount;
	}

	@Override
	public double acceptCash(double money) {
		return money*disCount;
	}

}
