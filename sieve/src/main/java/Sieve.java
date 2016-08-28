import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sieve {
	
	private int limit;
	private List<Integer> primes;

	public Sieve(int limit) {
		this.limit = limit;
		this.primes = getPrimes();
	}

	public List<Integer> getPrimes() {
		if (primes != null) return primes;
		List<Integer> result = new ArrayList<>();
		Set<Integer> composites = new HashSet<>(limit);
		for (int factor = 2; factor <= limit; factor++) {
			if (composites.contains(factor)) continue;
			result.add(factor);
			for (int product = factor * 2; product <= limit; product += factor) {
				composites.add(product);
			}
		}
		return Collections.unmodifiableList(result);
	}

}
