
public class Bob {

	public String hey(String speech) {
		if (speech == null)
			throw new IllegalArgumentException();
		if (speech.trim().isEmpty()) {
			return "Fine. Be that way!";
		} else if (speech.toUpperCase().equals(speech) && !speech.toLowerCase().equals(speech)) {
			return "Whoa, chill out!";
		} else if (speech.endsWith("?")) {
			return "Sure.";
		} else {
			return "Whatever.";
		}
	}

}
