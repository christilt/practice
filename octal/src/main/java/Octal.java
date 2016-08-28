import javax.swing.JOptionPane;

public class Octal {
	
	private String input;

	public Octal(String input) {
		this.input = input;
	}

	public int getDecimal() {
		if (!isValid(input)) return 0;
		String reverseInput = new StringBuilder(input).reverse().toString();
		int result = 0;
		for (int power = 0; power < reverseInput.length(); power++) {
			int digit = Integer.parseInt(reverseInput.substring(power, power + 1));
			result += digit * Math.pow(8, power);
		}
		return result;
	}

	private static boolean isValid (String input) {
		return input.matches("[0-7]+");
	}
}
