package stragety.test1;

import java.util.Scanner;

import util.Utils;

/**
	策略模式：是一种定义了一系列算法的方法，所有这些算法完成的都是同样的工作，只是实现不同，它
	可以以相同的方式调用所有的算法，减少各种算法类和使用算法类之前的耦合。
	简单说就是把不同的算法抽成不同的类，
	
	例子：输入商品价格和数量，得到总金额。会有不同的优惠策略：8折、9折、满减、折上300减100。。。
 */
public class Test {
	

	//1：只考虑打折
	public static BaseEntiy getMoney(BaseEntiy entiy) throws Exception{
		Double num2;
		Double price2;
		Double disCount2;
		if(Utils.isDouble(entiy.getNum())){
			num2 = Double.valueOf(entiy.getNum());
		}else{
			throw new Exception("数量num输入数字");
		};
		
		if(Utils.isDouble(entiy.getPrice())){
			price2 = Double.valueOf(entiy.getPrice());
		}else{
			throw new Exception("价格price输入数字");
		};
		if(Utils.isDouble(entiy.getDisCount())){
			disCount2 = Double.valueOf(entiy.getDisCount());
		}else{
			throw new Exception("折扣disCount输入数字");
		};
		entiy.setTotalMoney(num2*price2);
		entiy.setRealMoney(num2*price2*disCount2);
		return entiy;
	}
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数量：");
		String num = sc.nextLine();
		System.out.println("请输入价格：");
		String price = sc.nextLine();
		System.out.println("请输入折扣：");
		String disCount = sc.nextLine();
		
		BaseEntiy entiy = new BaseEntiy();
		entiy.setNum(num);
		entiy.setPrice(price);
		entiy.setDisCount(disCount);
		try {
			BaseEntiy money = getMoney(entiy);
			System.out.println("原价："+money.getTotalMoney()+",实付："+money.getRealMoney());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
