import java.util.ArrayList;
import java.util.List;

public class Robot {
	
	private String name;
	private List<String> previousNames;
	
	private String getLetterFromNumber(int number) {
		return number > 0 && number < 27 ? String.valueOf((char)(number + 'A' - 1)) : null;
	}
	
	private String generateName() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			int letterNumber = (int)(Math.random()*26);
			builder.append(getLetterFromNumber(letterNumber));
		}
		for (int i = 0; i < 3; i++) {
			int decimal = (int)(Math.random()*10);
			builder.append(decimal);
		}
		return builder.toString();
	}
	
	public Robot () {
		this.name = generateName();
		previousNames = new ArrayList<>();
		previousNames.add(this.name);
	}

	public String getName() {
		return this.name;
	}

	public void reset() {
		String checkName = generateName();
		while (previousNames.contains(checkName)) {
			checkName = generateName();
		}
		this.name = checkName;
		previousNames.add(this.name);
	}

}
