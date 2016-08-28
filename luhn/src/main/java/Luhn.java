public class Luhn {
	
	private long number;
	private int[] addEnds;
	private int checkSum;

	public Luhn(long number) {
		this.number = number;
		this.addEnds = getAddends();
		this.checkSum = getCheckSum();
	}

	public long getCheckDigit() {
		return number % 10;
	}

	public int[] getAddends() {
		if (addEnds != null) return addEnds;
		String numberString = String.valueOf(number);
		int length = numberString.length();
		int[] result = new int[length];
		for (int count = 0; count < length; count++) {
			int position = length - 1 - count;
			int digit = Integer.parseInt(numberString.substring(position, position + 1));
			result[position] = (count + 1) % 2 == 0 ? convert(digit) : digit;
		}
		return result;
	}

	private static int convert (int digit) {
		int result = digit * 2;
		if (result > 9) result -= 9;
		return result;
	}
	
	public int getCheckSum() {
		if (checkSum != 0) return checkSum;
		int result = 0;
		for (int i = 0; i < addEnds.length; i++) {
			result += addEnds[i];
		}
		return result;
	}

	public boolean isValid() {
		return checkSum % 10 == 0;
	}

	public static long create(long input) {
		int checkSum = new Luhn(input).getCheckSum();
		if (checkSum % 10 == 0) return input;
		long result = input * 10;
		checkSum = new Luhn(result).getCheckSum();
		while (checkSum % 10 != 0) {
			result++;
			checkSum = new Luhn(result).getCheckSum();
		}
		return result;
	}

}
