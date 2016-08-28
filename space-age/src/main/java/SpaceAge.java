
public class SpaceAge {

	static enum Planet {
		EARTH(1.00), MERCURY(0.2408467), VENUS(0.61519726), MARS(1.8808158), JUPITER(11.862615), SATURN(
				29.447498), URANUS(84.016846), NEPTUNE(164.79132);

		private final double earthYears;

		Planet(final double earthYears) {
			this.earthYears = earthYears;
		}

		public double earthYears() {
			return this.earthYears;
		}

	}

	public static final long SECONDS_IN_EARTH_YEAR = 31557600;

	private final long seconds;

	public SpaceAge(final long seconds) {
		if (seconds < 0)
			throw new IllegalArgumentException();
		this.seconds = seconds;
	}

	public final double getSeconds() {
		return this.seconds;
	}

	private final double ageOn(Planet planet) {
		return this.seconds / (planet.earthYears() * SECONDS_IN_EARTH_YEAR);
	}

	public final double onEarth() {
		return ageOn(Planet.EARTH);
	}

	public final double onMercury() {
		return ageOn(Planet.MERCURY);
	}

	public final double onVenus() {
		return ageOn(Planet.VENUS);
	}

	public final double onMars() {
		return ageOn(Planet.MARS);
	}

	public final double onJupiter() {
		return ageOn(Planet.JUPITER);
	}

	public final double onSaturn() {
		return ageOn(Planet.SATURN);
	}

	public final double onUranus() {
		return ageOn(Planet.URANUS);
	}

	public final double onNeptune() {
		return ageOn(Planet.NEPTUNE);
	}

}
