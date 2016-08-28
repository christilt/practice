import java.util.ArrayList;
import java.util.List;

public class Prime {

	public static int nth(int n) {
		if (n < 1) throw new IllegalArgumentException();
		
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		if (n <= 3) return primes.get(n - 1);

		int candidateNumber = 4;
		int candidate = 7;
		while (candidateNumber <= n) {
			boolean isPrime = true;
			for (int p: primes) {
				if (p > Math.sqrt(candidate)) break;
				if(candidate % p == 0) isPrime = false;
			}
			if (isPrime) {
				primes.add(candidate);
				candidateNumber++;
			}
			candidate += 2;
		}
		return primes.get(primes.size() - 1);
	}

}
