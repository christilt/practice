import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allergies {

	private int totalScore;
	private List<Allergen> allergies;

	public Allergies(int totalScore) {
		this.totalScore = totalScore;
		this.allergies = getList();
	}

	public boolean isAllergicTo(Allergen allergen) {
		return allergies.contains(allergen);
	}

	private static String reverseBinaryStringOf(int score) {
		StringBuilder builder = new StringBuilder(Integer.toBinaryString(score));
		return builder.reverse().toString();
	}

	private static Allergen allergenOf(int score) {
		for (Allergen allergen : Allergen.values()) {
			if (allergen.getScore() == score)
				return allergen;
		}
		return null;
	}

	public List<Allergen> getList() {
		if (allergies != null)
			return allergies;
		List<Allergen> result = new ArrayList<>();
		String reverseBinaryString = reverseBinaryStringOf(totalScore);
		for (int power = 0; power < reverseBinaryString.length(); power++) {
			if (reverseBinaryString.charAt(power) == '1') {
				Allergen allergen = allergenOf((int) Math.pow(2, power));
				if (allergen != null)
					result.add(allergen);
			}
		}
		return Collections.unmodifiableList(result);
	}

}
