package stragety.sort;

import java.util.ArrayList;

/**
 * 方法头上的注释都是引出的后一个方法
 * @Title: SortUtil.java
 * @author Hanzhonghua
 * @date 2017年2月13日下午1:52:02
 */
public class SortUtil {

	/*
	 * 对基本类型冒泡排序，现在问题来了，我们需要对对象类型排序 比如现在有一个类Cat，
	 * 拥有身高high和体中height，需要根据 身高进行排序
	 */
	/*public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}*/

	/*
	 * 对猫的进行针对于身高的冒泡排序,现在又有问题了，假如需要针对猫的体中排序
	 * 现在又来了一个Dog类，需要根据狗的饭量foot进行排序，怎么办？总不能一直增加
	 * 方法吧，又说了可以传递一个Object数组，但是传递Object数组需要怎么排序呢？
	 * 
	 * 我们可以这么做，定义一个接口，Comparable接口有一个comparTo方法，可以比较
	 * 两个对象的大小，让具体实现类实现如何比较，这样以后扩展起来也很方便，只要实现接口，
	 * 如何比较自己实现即可
	 */
	/*public static void bubbleSort(Cat[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j].getHigh() > a[j + 1].getHigh()) {
					Cat temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}*/

	/*
	 * 这样不管比较什么对象，只要实现了自己定义的Comparable接口，定义自己的比较方法
	 * 都可以实现比较了，但是，现在问题又来了，比如Cat类中现在想改成根据体重比较大小
	 * 或者根据身高和体中的和比较大小，现在只是一个Comparable就不行，我们实现这种可
	 * 扩展的功能，首先想到的就是接口了，现在我们定义一个接口Comparator有一方法compare
	 * 拥有两个参数，Cat可以实现这个接口方法，定义自己的比较大小实现方法
	 */
	public static void bubbleSort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					Comparable temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	/*
	 * 打印数组
	 */
	public static void print(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if (a.length == i + 1) {
				System.out.print(a[i] + "]");
				return;
			}
			System.out.print(a[i] + ", ");
		}
	}

	private static void print(Object[] c) {
		for (int i = 0; i < c.length; i++) {
			if (c.length == i + 1) {
				System.out.print(c[i]);
				return;
			}
			System.out.print(c[i] + ", ");
		}
	}

	/*
	 * 
	 */
	public static void main(String[] args) {
		CatSortByHigh high = new CatSortByHigh();
		Cat c1 = new Cat(1, 2);
		c1.setC(high);
		Cat c2 = new Cat(4, 5);
		c2.setC(high);
		Cat c3 = new Cat(3, 1);
		c3.setC(high);
		Cat[] c = { c1, c2, c3 };
		//int[] a = { 1, 4, 3, 2, 6, 5 };
		// bubbleSort(a);
		
		bubbleSort(c);
		print(c);
	}

}
