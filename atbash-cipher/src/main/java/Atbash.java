
public class Atbash {

	private static char invertCharacter(char character) {
		int baseValue = ((int) 'a') - 1;
		int alphaValue = (int) character - baseValue - 1;
		int resultValue = (int) (baseValue + Math.abs(26 - alphaValue));
		return (char) resultValue;
	}

	public static String encode(String input) {
		StringBuilder builder = new StringBuilder();
		char[] inputChars = input.replaceAll("\\W", "").toLowerCase().toCharArray();
		int counter = 1;
		for (char c : inputChars) {
			if (counter % 6 == 0) {
				builder.append(" ");
				counter++;
			}
			if (Character.isAlphabetic(c)) {
				builder.append(invertCharacter(c));
			} else {
				builder.append(c);
			}
			counter++;
		}
		return builder.toString();
	}

	public static String decode(String input) {
		StringBuilder builder = new StringBuilder();
		char[] inputChars = input.replaceAll("\\W", "").toLowerCase().toCharArray();
		for (char c : inputChars) {
			if (Character.isAlphabetic(c)) {
				builder.append(invertCharacter(c));
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

}
