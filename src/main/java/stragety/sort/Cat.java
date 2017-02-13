package stragety.sort;

public class Cat implements Comparable {

	private int high;
	private int weight;
	// 这个比较方法就是用到了设计模式的策略模式，根据不同的具体策略实现不用的比较方法
	private Comparator c = new CatSortByHigh();

	public Comparator getC() {
		return c;
	}

	public void setC(Comparator c) {
		this.c = c;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat [high=" + high + ", height=" + weight + "]";
	}

	public Cat(int high, int weight) {
		this.high = high;
		this.weight = weight;
	}
	/*
	 *  重写compareTo方法，实现自己的比较方法，比较该对象与指定对象的顺序
	 *  如果该对象小于、等于或大于指定对象，则分别返回-1、0或1
	 */
	/*@Override
	public int compareTo(Comparable o) {
		if (o instanceof Cat) {
			Cat c = (Cat) o;
			if (this.getHigh() > c.getHigh()) {
				return 1;
			} else if (this.getHigh() == c.getHigh()) {
				return 0;
			}
			return -1;
		}
		throw new ClassCastException("类型转换异常");
	}*/

	// 我们使用实现了Comparator接口的实现方法
	@Override
	public int compareTo(Comparable o) {
		return c.compare(this, o);
	}

}
