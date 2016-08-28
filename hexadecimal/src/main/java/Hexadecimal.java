import java.util.HashMap;
import java.util.Map;

public class Hexadecimal {
	
	private static Map<Character,Integer> MAP;
	
	static {
		MAP = new HashMap<Character,Integer>();
		MAP.put('0', 0);
		MAP.put('1', 1);
		MAP.put('2', 2);
		MAP.put('3', 3);
		MAP.put('4', 4);
		MAP.put('5', 5);
		MAP.put('6', 6);
		MAP.put('7', 7);
		MAP.put('8', 8);
		MAP.put('9', 9);
		MAP.put('a', 10);
		MAP.put('b', 11);
		MAP.put('c', 12);
		MAP.put('d', 13);
		MAP.put('e', 14);
		MAP.put('f', 15);
	}

	private static boolean isValid(String hexString) {
		return hexString.matches("[0-9[a-f]]+") ? true : false;
	}
	
	public static int toDecimal(String hexString) {
		if (!isValid(hexString)) return 0;
		String reverseHexString = new StringBuilder(hexString).reverse().toString();
		int total = 0;
		for (int power = 0; power < reverseHexString.length(); power++) {
			char hexCharacter = reverseHexString.charAt(power);
			total += MAP.get(hexCharacter) * Math.pow(16, power);
		}
		return total;
	}

}
