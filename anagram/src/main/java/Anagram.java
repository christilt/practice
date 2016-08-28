import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

	private String word;
	private char[] wordAsChars;
	
	public Anagram(String input) {
		if (input == null || input == "") throw new IllegalArgumentException();
		this.word = input;
		wordAsChars = input.toLowerCase().toCharArray();
		Arrays.sort(wordAsChars);
	}
	
	private boolean isAnagramOf (String candidate) {
		if (word.length() != candidate.length()) return false;
		if (word.equalsIgnoreCase(candidate)) return false;
		char[] candidateAsChars = candidate.toLowerCase().toCharArray();
		Arrays.sort(candidateAsChars);
		for (int i = 0; i < word.length(); i++) {
			if (wordAsChars[i] != candidateAsChars[i]) return false;
		}
		return true;
	}

	public List<String> match(List<String> candidates) {
		if (candidates == null || candidates.isEmpty()) throw new IllegalArgumentException();
		List<String> result = new ArrayList<>();
		for (String candidate : candidates) {
			if (isAnagramOf(candidate)) result.add(candidate);
		}
		return result;
	}
}