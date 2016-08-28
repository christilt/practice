
public class Binary {
	
	private String binaryInput;

	public Binary(String binaryInput) {
		if (binaryInput == null) throw new IllegalArgumentException();
		this.binaryInput = binaryInput;
	}

	private static boolean isBinary(String input) {
		return input.matches("[1|0]++") ? true : false;
	}
	
	public int getDecimal() {
		if (!isBinary(binaryInput)) return 0;
		int decimal = 0;
		for (int power = 0; power < binaryInput.length(); power++) {
			int position = binaryInput.length() - power - 1;
			int digit = Character.getNumericValue(binaryInput.charAt(position));
			decimal += digit * Math.pow(2, power);
		}
		return decimal;
	}

}
