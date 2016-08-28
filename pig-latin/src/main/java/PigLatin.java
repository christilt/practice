
public class PigLatin {
	
	private static final String CONSONANT = "[^aeiou]+";

	public static String translate(String input) {
		StringBuilder builder = new StringBuilder();
		String[] words = input.split("\\s");
		for (int i = 0; i < words.length; i++) {
			builder.append(translateWord(words[i]));
			if (i + 1 != words.length) builder.append(" ");
		}
		return builder.toString();
	}

	private static String translateWord(String input) {
		StringBuilder builder = new StringBuilder(input);
		String firstLetter = builder.substring(0, 1);
		if (firstLetter.matches(CONSONANT)) {
			if (builder.substring(1, 3).equals("qu")) {
				builder.append(builder.substring(0, 3));
				builder.delete(0, 3);
			} else if (builder.substring(0, 2).equals("ch")) {
				builder.append("ch");
				builder.delete(0, 2);
			} else if (builder.substring(0, 2).equals("qu")) {
				builder.append("qu");
				builder.delete(0, 2);
			} else if (builder.substring(0, 2).equals("th")) {
				builder.append("th");
				builder.delete(0, 2);
				if (builder.substring(0, 1).equals("r")) {
					builder.append("r");
					builder.delete(0, 1);
				}
			} else if (builder.substring(0, 3).equals("sch")) {
				builder.append("sch");
				builder.delete(0, 3);
			} else if (!builder.substring(0, 2).equals("yt") && !builder.substring(0, 2).equals("xr")) {
				builder.append(firstLetter);
				builder.deleteCharAt(0);
			}
		}
		builder.append("ay");
		return builder.toString();
	}
}