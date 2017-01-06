package proxy.reflect.demo;

public class Student {

	private String name ;
	private Integer age ;
	public Double money;
	
	@SuppressWarnings("unused")
	private Student() {}
	public Student(String name){
		this.name = name;
	}
	
	Student(Integer age){
		this.age = age;
	}
	
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void learn(){
		System.out.println("the student xiaoli is learning");
	}
	
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
