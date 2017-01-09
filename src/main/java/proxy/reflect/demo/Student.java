package proxy.reflect.demo;

public class Student {

	private String name ;
	Integer age ;
	public Double money;
	
	private Student() {}
	public Student(String name){
		this.name = name;
	}
	Student(Integer age){
		this.age = age;
	}
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public void learn(){
		System.out.println("学生正在学习");
	}
	public void learn(String name){
		System.out.println(name+"正在学习");
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
