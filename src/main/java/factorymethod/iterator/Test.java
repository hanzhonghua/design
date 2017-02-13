package factorymethod.iterator;

public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		for (int i = 0; i < 18; i++) {
			list.add(i);
		}
		System.out.println(list.size());
	}
}
