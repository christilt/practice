public class Pangrams {

	public static boolean isPangram(String input) {
		if (input == null) throw new IllegalArgumentException();
		if (input.length() < 26) return false;
		input = input.toLowerCase();
		for (Character c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			if (!input.contains(""+c)) return false;
		}
		return true;
	}

}
