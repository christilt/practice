import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

	private static final Map<PlaceValue, Map<String, String>> MAPS = initialiseMAPS();

	private int value;
	private String arabicNumeral;
	private String romanNumeral;

	private static enum PlaceValue {
		UNITS(1), TENS(2), HUNDREDS(3), THOUSANDS(4);

		private int placePosition;

		PlaceValue(int placePosition) {
			this.placePosition = placePosition;
		}

		static PlaceValue getPlaceValueByPlacePosition(int placePosition) {
			switch (placePosition) {
			case 1:
				return UNITS;
			case 2:
				return TENS;
			case 3:
				return HUNDREDS;
			case 4:
				return THOUSANDS;
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	private static final Map<String, String> initialiseUNITS() {
		Map<String, String> units = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			switch (s) {
			case "0":
				units.put(s, "");
				break;
			case "1":
				units.put(s, "I");
				break;
			case "2":
				units.put(s, "II");
				break;
			case "3":
				units.put(s, "III");
				break;
			case "4":
				units.put(s, "IV");
				break;
			case "5":
				units.put(s, "V");
				break;
			case "6":
				units.put(s, "VI");
				break;
			case "7":
				units.put(s, "VII");
				break;
			case "8":
				units.put(s, "VIII");
				break;
			case "9":
				units.put(s, "IX");
				break;
			}
		}
		return Collections.unmodifiableMap(units);
	}

	private static final Map<String, String> initialiseTENS() {
		Map<String, String> tens = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			switch (s) {
			case "0":
				tens.put(s, "");
				break;
			case "1":
				tens.put(s, "X");
				break;
			case "2":
				tens.put(s, "XX");
				break;
			case "3":
				tens.put(s, "XXX");
				break;
			case "4":
				tens.put(s, "XL");
				break;
			case "5":
				tens.put(s, "L");
				break;
			case "6":
				tens.put(s, "LX");
				break;
			case "7":
				tens.put(s, "LXX");
				break;
			case "8":
				tens.put(s, "LXXX");
				break;
			case "9":
				tens.put(s, "XC");
				break;
			}
		}
		return Collections.unmodifiableMap(tens);
	}

	private static final Map<String, String> initialiseHUNDREDS() {
		Map<String, String> hundreds = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			switch (s) {
			case "0":
				hundreds.put(s, "");
				break;
			case "1":
				hundreds.put(s, "C");
				break;
			case "2":
				hundreds.put(s, "CC");
				break;
			case "3":
				hundreds.put(s, "CCC");
				break;
			case "4":
				hundreds.put(s, "CD");
				break;
			case "5":
				hundreds.put(s, "D");
				break;
			case "6":
				hundreds.put(s, "DC");
				break;
			case "7":
				hundreds.put(s, "DCC");
				break;
			case "8":
				hundreds.put(s, "DCCC");
				break;
			case "9":
				hundreds.put(s, "CM");
				break;
			}
		}
		return Collections.unmodifiableMap(hundreds);
	}

	private static final Map<String, String> initialiseTHOUSANDS() {
		Map<String, String> thousands = new HashMap<>();
		for (int i = 1; i < 4; i++) {
			String s = String.valueOf(i);
			switch (s) {
			case "1":
				thousands.put(s, "M");
				break;
			case "2":
				thousands.put(s, "MM");
				break;
			case "3":
				thousands.put(s, "MMM");
				break;
			}
		}
		return Collections.unmodifiableMap(thousands);
	}

	private static final Map<PlaceValue, Map<String, String>> initialiseMAPS() {
		Map<PlaceValue, Map<String, String>> maps = new HashMap<PlaceValue, Map<String, String>>();
		for (int i = 1; i <= 4; i++) {
			switch (i) {
			case 1:
				maps.put(PlaceValue.getPlaceValueByPlacePosition(i), initialiseUNITS());
				break;
			case 2:
				maps.put(PlaceValue.getPlaceValueByPlacePosition(i), initialiseTENS());
				break;
			case 3:
				maps.put(PlaceValue.getPlaceValueByPlacePosition(i), initialiseHUNDREDS());
				break;
			case 4:
				maps.put(PlaceValue.getPlaceValueByPlacePosition(i), initialiseTHOUSANDS());
				break;
			}
		}
		return Collections.unmodifiableMap(maps);
	}

	private static String convert(String arabicNumeral) {
		if (arabicNumeral.equals("0"))
			return "";
		StringBuilder builder = new StringBuilder();
		int placePosition = arabicNumeral.length();
		for (int readPosition = 0; readPosition < arabicNumeral.length(); readPosition++) {
			PlaceValue placeValue = PlaceValue.getPlaceValueByPlacePosition(placePosition);
			String digit = Character.toString(arabicNumeral.charAt(readPosition));
			builder.append(MAPS.get(placeValue).get(digit));
			placePosition--;
		}
		return builder.toString();
	}

	public RomanNumeral(int value) {
		if (value < 0 || value > 3000)
			throw new IllegalArgumentException();
		this.value = value;
		this.arabicNumeral = String.valueOf(value);
		this.romanNumeral = convert(arabicNumeral);
	}

	public Object getRomanNumeral() {
		return romanNumeral;
	}

}