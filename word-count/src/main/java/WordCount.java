import java.util.HashMap;
import java.util.Map;

public class WordCount {
	
	public Map<String, Integer> phrase(String input) {
		if (input == null) throw new IllegalArgumentException();
		Map<String, Integer> result = new HashMap<>();
		input = input.replaceAll("\\p{Punct}","").toLowerCase();
		String[] parsedInput = input.split("\\s+");
		for (String word : parsedInput) {
			result.put(word, result.containsKey(word) ? result.get(word) + 1 : 1);
		}
		return result;
	}
	
}