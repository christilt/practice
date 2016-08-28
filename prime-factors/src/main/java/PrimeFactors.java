import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeFactors {

//	private static boolean isPrime(long candidateNumber) {
//		long nextCandidateFactor = 2;
//		while (candidateNumber % nextCandidateFactor != 0 && nextCandidateFactor < candidateNumber) {
//			nextCandidateFactor++;
//		}
//		return nextCandidateFactor == candidateNumber ? true : false;
//	}
//
//	private static long nextPrime(long currentPrime) {
//		long result = currentPrime + 1;
//		while (!isPrime(result)) {
//			result++;
//		}
//		return result;
//	}

	public static List<Long> getForNumber(long input) {
		if (input < 0)
			throw new IllegalArgumentException();
		if (input == 0)
			return Collections.EMPTY_LIST;
		List<Long> result = new ArrayList<>();
		long factor = 2;
		while (input > 1) {
			while (input % factor == 0) {
				result.add(factor);
				input /= factor;
			}
			factor++;
		}
		return result;
	}

}
