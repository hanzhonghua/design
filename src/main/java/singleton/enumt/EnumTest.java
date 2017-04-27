package singleton.enumt;

/*
 * enum和普通类没有什么区别除了不可以继承，可以定义方法写main方法，实现了Comparable和Serializable
 * 定义自己的方法必须在每个方法加上分号，定义的每个属性以逗号间隔，最后一个使用分号结尾
 * 
 * 自己创建的Enum已经默认继承了Enum类，而Java中只支持单继承，所以不可以再继承别的类了
 */
public enum EnumTest{

	GGG, BBB, VVV;
	
	public String toString(){
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) + lower;
	}
	
	public static void main(String[] args) {
//		EnumTest[] values = EnumTest.values();
		for (EnumTest enumTest : EnumTest.values()) {
			System.out.println(enumTest.ordinal());
			System.out.println(enumTest.compareTo(EnumTest.GGG));
			System.out.println(enumTest.equals(EnumTest.GGG));
			System.out.println(enumTest == EnumTest.GGG);
			System.out.println(enumTest.getDeclaringClass());
			System.out.println(enumTest);
			System.out.println(EnumTest.valueOf("GGG"));
		}
	}
}
