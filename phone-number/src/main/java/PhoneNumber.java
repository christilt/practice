
public class PhoneNumber {

	private String phoneNumber;

	private static final String BAD_CHARACTERS = "\\D";
	private static final String INVALID_NUMBER = "0000000000";

	private static final String clean(String phoneNumber) {
		return phoneNumber.replaceAll(BAD_CHARACTERS, "");
	}

	private static final String validate(String phoneNumber) {
		if (phoneNumber == null)
			throw new IllegalArgumentException();
		if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
			return INVALID_NUMBER;
		} else if (phoneNumber.length() == 10) {
			return phoneNumber;
		} else { // phoneNumber.length() == 11
			return phoneNumber.charAt(0) == '1' ? phoneNumber.substring(1) : INVALID_NUMBER;
		}
	}

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = validate(clean(phoneNumber));
	}

	public String getNumber() {
		return phoneNumber;
	}

	public String getAreaCode() {
		return phoneNumber.substring(0, 3);
	}

	public String pretty() {
		return 	"(" + getAreaCode() + ") " + 
				phoneNumber.substring(3, 6) + "-" + 
				phoneNumber.substring(6);
	}

}
