import java.util.Random;

public class Cipher {
	
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	private String key;

	public Cipher() {
		this.key = generateRandomKey(100);
	}

	private static String generateRandomKey(int length) {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			builder.append(ALPHABET.charAt(random.nextInt(26)));
		}
		return builder.toString();
	}
	
	public Cipher(String key) {
		if (!key.matches("[a-z]+")) throw new IllegalArgumentException();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String encode(String encodeString) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < encodeString.length(); i++) {
			builder.append(encodeChar(encodeString.charAt(i),key.charAt(i)));
		}
		return builder.toString();
	}

	private static char encodeChar (char candidateChar, char keyChar) {
		int resultValue = ALPHABET.indexOf(candidateChar) + ALPHABET.indexOf(keyChar);
		if (resultValue >= 26) resultValue -= 26;
		return (char) ('a' + resultValue);
	}

	public String decode(String decodeString) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < decodeString.length(); i++) {
			builder.append(decodeChar(decodeString.charAt(i),key.charAt(i)));
		}
		return builder.toString();
	}

	private static char decodeChar (char candidateChar, char keyChar) {
		int resultValue = ALPHABET.indexOf(candidateChar) - ALPHABET.indexOf(keyChar);
		if (resultValue < 0 ) resultValue += 26;
		return (char) ('a' + resultValue);
	}
}
