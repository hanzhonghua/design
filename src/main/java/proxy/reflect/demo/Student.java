package proxy.reflect.demo;

public class Student {

	private String name ;
	Integer age ;
	public Double money;
	
	public Student() {}
	Student(String name){
		this.name = name;
	}
	private Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public static void learn(String name,String address){
		System.out.println(name+"在"+address+"学习");
	}
	private void learn(){
		System.out.println("学生正在学习");
	}
	String learn(String name){
		return name+"正在学习";
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
