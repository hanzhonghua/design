package singleton.enumt;

/*
 * 如代码所示，如果想要给每个枚举实例加上一些属性，如WEST中的aaaa和ccc，需要创建对应的构造方法
 * 构造方法里的属性和WEST中的属性顺序一一对应，可以设置属性并通过getset方法设值返回值，并且每一个
 * 枚举实例中的个数是需要相等的
 * 
 * 注意枚举中的构造方法只能在enum定义的内部使用构造方法创建实例，一旦enum定义结束，编译器不在允许
 * 使用构造方法创建实例了，既是是public
 */
public enum OzWitch {

	WEST("aaaa","ccc"),
	SOUTH("bbbbb","dddd");
	private String desc;
	private String value;
	public String getDesc(){
		return desc;
	}
	private String getValue(){
		return value;
	}
	
	private OzWitch(String desc,String value){
		this.desc = desc;
		this.value = value;
	}
	
	public static void main(String[] args) {
		for (OzWitch o : OzWitch.values()) {
			System.out.println(o+":"+o.getDesc());
			System.out.println(o+":"+o.getValue());
		}
	}
}
