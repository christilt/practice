import java.util.LinkedList;
import java.util.List;

public class Crypto {

	private String inputText;
	private String plainText;
	private int squareSize;
	private List<String> segments;

	public Crypto(String inputText) {
		this.inputText = inputText;
		this.plainText = getNormalizedPlaintext();
		this.squareSize = getSquareSize();
		this.segments = getPlaintextSegments();
	}

	public String getNormalizedPlaintext() {
		if (plainText != null) {
			return plainText;
		} else {
			return inputText.replaceAll("\\W", "").toLowerCase();
		}
	}

	public int getSquareSize() {
		return (int) Math.ceil(Math.sqrt(plainText.length()));
	}

	public List<String> getPlaintextSegments() {
		List<String> result = new LinkedList<String>();
		int interval = squareSize;
		for (int i = 0; i < plainText.length(); i += interval) {
			if ((i + interval) > plainText.length())
				interval = plainText.length() - i;
			result.add(plainText.substring(i, i + interval));
		}
		return result;
	}

	public String getCipherText() {
		StringBuilder builder = new StringBuilder();
		for (int c = 0; c < squareSize; c++) {
			for (int r = 0; r < segments.size(); r++) {
				if (segments.get(r) != null && segments.get(r).length() > c) {
					builder.append(segments.get(r).charAt(c));
				}
			}
		}
		return builder.toString();
	}

	public String getNormalizedCipherText() {
		StringBuilder builder = new StringBuilder();
		for (int c = 0; c < squareSize; c++) {
			for (int r = 0; r < segments.size(); r++) {
				if (segments.get(r) != null && segments.get(r).length() > c) {
					builder.append(segments.get(r).charAt(c));
				}
			}
			if (c < squareSize - 1)
				builder.append(" ");
		}
		return builder.toString();
	}

}
