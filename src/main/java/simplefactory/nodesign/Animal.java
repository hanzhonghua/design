package simplefactory.nodesign;

public class Animal {

	public Animal getAnimal(String type) {
		Animal animal = null;
		if ("taidi".equals(type)) {
			animal = new TaiDi();
		} else if ("keji".equals(type)) {
			animal = new KeJi();
		} else if ("jinmao".equals(type)) {
			animal = new JinMao();
		}
		return animal;
	}
	
	public void eat(){}
	public void sleep(){}

	public static void main(String[] args) {
		Animal animal = new Animal();
		Animal a = animal.getAnimal("taidi");
		a.eat();
		a.sleep();
	}
}
