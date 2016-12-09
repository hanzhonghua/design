package design.util;

public class Utils {

	public static boolean isDouble(String value){
		try {
			Double.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
