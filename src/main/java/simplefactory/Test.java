package simplefactory;

import java.util.Scanner;

import simplefactory.entiy.Nums;

/**
      输入2个数字和一个运算符，就结果：使用到了简单工厂模式，对象的创建和使用分离
      有一个工厂，专门用来创建对象，不同的操作符对应不同的工厂子类；工厂方法根据传入
      的操作符不同创建不同的类
 */
public class Test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("输入numA：");
		String numA = s.nextLine();
		System.out.println("输入运算符：");
		String operation = s.nextLine();
		System.out.println("输入numB：");
		String numB = s.nextLine();
		Nums nums = new Nums();
		nums.setNumA(Double.valueOf(numA));
		nums.setNumB(Double.valueOf(numB));
		try {
			System.out.println("运算结果：" + Operation.operation(operation).getSum(nums));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			s.close();
		} 
	}

}
