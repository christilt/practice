import java.util.HashMap;
import java.util.Map;

public class DNA {
	
	String DNAString;
	
	public DNA (String DNAString) {
		this.DNAString = DNAString;
	}
	
	private static boolean isValidNucleotide (char candidateNucleotide) {
		if (candidateNucleotide == 'A' ||
			candidateNucleotide == 'C' ||
			candidateNucleotide == 'G' ||
			candidateNucleotide == 'T')
			return true;
		return false;
	}
	
	public int count (char candidateNucleotide) {
		if (!DNA.isValidNucleotide(candidateNucleotide)) throw new IllegalArgumentException();
		int result = 0;
		for (int i = 0; i < DNAString.length(); i++) {
			if (candidateNucleotide == DNAString.charAt(i)) { result++; }
		}
		return result;
	}
	
	public Map<Character, Integer> nucleotideCounts () {
		Map<Character, Integer> result = new HashMap<>();
		result.put('A', count('A'));
		result.put('C', count('C'));
		result.put('G', count('G'));
		result.put('T', count('T'));
		return result;
	}
	
}
