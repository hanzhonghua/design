package singleton.enumt;

public class SwitchEnum {

	ColorEnum color = ColorEnum.RED;

	@SuppressWarnings("incomplete-switch")
	public void change() {
		switch (color) {
		case RED:
			color = ColorEnum.GREEN;
			break;
		case GREEN:
			color = ColorEnum.YELLOW;
			break;
		case YELLOW:
			color = ColorEnum.RED;
			break;
		}
	}

	public String toString() {
		return "this color is：" + color;
	}
	
	public static void main(String[] args) {
		SwitchEnum se = new SwitchEnum();
		for (int i = 0; i < 7; i++) {
			
			System.out.println(se);
			se.change();
		}
	}
}
