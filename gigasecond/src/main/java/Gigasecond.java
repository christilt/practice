import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

	public static final long ONE_GIGASECOND = 1_000_000_000;

	private final LocalDateTime referenceDateTime;

	public Gigasecond(LocalDate referenceDate) {
		if (referenceDate == null)
			throw new IllegalArgumentException();
		this.referenceDateTime = referenceDate.atStartOfDay();
	}

	public Gigasecond(LocalDateTime referenceDateTime) {
		this.referenceDateTime = referenceDateTime;
	}

	public LocalDateTime getDate() {
		return this.referenceDateTime.plusSeconds(ONE_GIGASECOND);
	}

}
