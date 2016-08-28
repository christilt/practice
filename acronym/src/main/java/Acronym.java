
public class Acronym {

	public static String generate(String input) {
		if (input == null)
			throw new IllegalArgumentException();
		String parsedInput = input.trim();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < parsedInput.length(); i++) {
			char c2 = parsedInput.charAt(i);
			if (c2 == ':')
				break;
			if (Character.isUpperCase(c2)) {
				builder.append(c2);
			} else if (i > 0) {
				char c1 = parsedInput.charAt(i - 1);
				if (!Character.isLetter(c1) && Character.isLetter(c2))
					builder.append(c2);
			}
		}
		return builder.toString().toUpperCase();
	}

}
