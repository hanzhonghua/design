package design.stragety.test2.impl;

import design.stragety.test2.CaseSupper;

//原价
public class CashOriginal implements CaseSupper{

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
