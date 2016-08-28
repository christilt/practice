public class Raindrops {

	public static String convert(int input) {
		StringBuilder builder = new StringBuilder();
		if (input % 3 == 0) builder.append("Pling");
		if (input % 5 == 0) builder.append("Plang");
		if (input % 7 == 0) builder.append("Plong");
		return builder.length() == 0 ? String.valueOf(input) : builder.toString();
	}

}
