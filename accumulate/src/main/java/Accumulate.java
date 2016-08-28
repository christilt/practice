import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Accumulate {

	public static <T> List<T> accumulate(List<T> input, Function<T, T> function) {
		List<T> result = new LinkedList<>();
		for (T t : input) {
			result.add(function.apply(t));
		}
		return result;
	}

}
