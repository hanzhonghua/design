package design.stragety.test3.impl;

import design.stragety.test3.CaseSupper;

//原价
public class CashOriginal implements CaseSupper{

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
