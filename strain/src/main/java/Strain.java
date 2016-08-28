import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Strain {

	public static <T> List<T> keep(List<T> input, Predicate<T> predicate) {
		List<T> result = new ArrayList<>();
		for (T t : input) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	public static <T> List<T> discard(List<T> input, Predicate<T> predicate) {
		List<T> result = new ArrayList<>(input);
		for (T t : input) {
			if (predicate.test(t)) {
				result.remove(t);
			}
		}
		return result;
	}

}
