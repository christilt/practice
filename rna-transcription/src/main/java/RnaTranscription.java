import java.util.HashMap;
import java.util.Map;

public class RnaTranscription {
	
	private static final Map<Character,Character> MAP;
	
	static {
		MAP = new HashMap<Character,Character>();
		MAP.put('G', 'C');
		MAP.put('C', 'G');
		MAP.put('T', 'A');
		MAP.put('A', 'U');
	}
	
	public static String ofDna(String dna) {
		if (dna == null || !dna.matches("[gctaGCTA]*")) throw new IllegalArgumentException();
		dna = dna.toUpperCase();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < dna.length(); i++) {
			char nucleotide = dna.charAt(i);
			builder.append(MAP.get(nucleotide));
		}
		return builder.toString();
	}

}
