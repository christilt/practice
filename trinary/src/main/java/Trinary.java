
public class Trinary {

	public static int toDecimal(String trinaryString) {
		if (!trinaryString.matches("[012]+")) return 0;
		String reverseTrinaryString = new StringBuilder(trinaryString).reverse().toString();
		int result = 0;
		for (int power = 0; power < reverseTrinaryString.length(); power++) {
			result += Character.getNumericValue(reverseTrinaryString.charAt(power)) * Math.pow(3, power);
		}
		return result;
	}

}
