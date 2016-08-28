
public class Triangle {

	private final double a;
	private final double b;
	private final double c;
	private final TriangleKind kind;

	private static final boolean isValidTriangle(double a, double b, double c) {
		return a + b > c && b + c > a && c + a > b;
	}

	public final TriangleKind getKind() {
		if (kind != null)
			return kind;
		if (a == b && b == c) {
			return TriangleKind.EQUILATERAL;
		} else if (a == b || b == c || c == a) {
			return TriangleKind.ISOSCELES;
		} else {
			return TriangleKind.SCALENE;
		}
	}

	public Triangle(double a, double b, double c) throws TriangleException {
		if (!isValidTriangle(a, b, c))
			throw new TriangleException("Not a valid triangle");
		this.a = a;
		this.b = b;
		this.c = c;
		this.kind = getKind();
	}

}
