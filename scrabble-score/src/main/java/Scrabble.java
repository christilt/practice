public class Scrabble {

	static enum Multiplier {
		SINGLE("single", 1), DOUBLE("double", 2), TRIPLE("triple", 3);

		static final int MAX_TEXT_LENGTH = 6;
		static final char TRIGGER = ':';

		private String text;
		private int value;

		Multiplier(String text, int value) {
			this.text = text;
			this.value = value;
		}

		String text() {
			return this.text;
		}

		int value() {
			return this.value;
		}

		public static final Multiplier of(String candidateText) {
			if (candidateText == null)
				throw new IllegalArgumentException();
			if (candidateText.equalsIgnoreCase(DOUBLE.text())) {
				return Multiplier.DOUBLE;
			} else if (candidateText.equalsIgnoreCase(TRIPLE.text())) {
				return Multiplier.TRIPLE;
			} else {
				return Multiplier.SINGLE;
			}
		}

	}

	private final String input;
	private final Integer score;

	public Scrabble(String input) {
		if (input == null) {
			this.input = "";
		} else {
			this.input = input.trim().toUpperCase();
		}
		this.score = getScore();
	}

	private static final int letterScore(char letter) {
		switch (letter) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
		case 'L':
		case 'N':
		case 'R':
		case 'S':
		case 'T':
			return 1;
		case 'D':
		case 'G':
			return 2;
		case 'B':
		case 'C':
		case 'M':
		case 'P':
			return 3;
		case 'F':
		case 'H':
		case 'V':
		case 'W':
		case 'Y':
			return 4;
		case 'K':
			return 5;
		case 'J':
		case 'X':
			return 8;
		case 'Q':
		case 'Z':
			return 10;
		default:
			throw new IllegalArgumentException();
		}
	}

	public final int getScore() {
		if (score != null)
			return score;
		if (input == null || input == "")
			return 0;
		int subTotal = 0;
		int position = 0;
		while (position < input.length()) {
			char candidateLetter = input.charAt(position);
			if (Character.isLetter(candidateLetter)) {
				Multiplier multiplier = Multiplier.SINGLE;
				int triggerPosition = position + 1;
				int multiplierPosition = position + 2;
				int nextPosition = multiplierPosition + Multiplier.MAX_TEXT_LENGTH;
				if (nextPosition - 1 < input.length() && input.charAt(triggerPosition) == Multiplier.TRIGGER) {
					multiplier = Multiplier.of(input.substring(multiplierPosition, nextPosition));
				}
				subTotal += multiplier.value() * letterScore(candidateLetter);
				position = (multiplier == Multiplier.SINGLE) ? position + 1 : nextPosition;
			} else {
				position++;
			}
		}
		return subTotal;
	}


}
