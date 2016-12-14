package design.stragety.teste3.impl;

import design.stragety.teste3.CaseSupper;
import design.util.Utils;

//满减：输入满多少参数，和减多少参数
public class CashRebate implements CaseSupper {

	private double conditionMoney = 0;
	private double rebateMoney = 0;
	public CashRebate(String conditionMoney,String rebateMoney) throws Exception {
		if(Utils.isDouble(conditionMoney)){
			this.conditionMoney = Double.valueOf(conditionMoney);
		}else{
			throw new Exception("只能输入数字");
		}
		if(Utils.isDouble(conditionMoney)){
			this.rebateMoney = Double.valueOf(rebateMoney);
		}else{
			throw new Exception("只能输入数字");
		}
	}

	@Override
	public double acceptCash(double money) {
		if(money >=conditionMoney){
			return money-rebateMoney;
		}
		return money;
	}

	public static void main(String[] args) {
		System.out.println(Math.floor(300/200)*100);
	}
}
