public class PascalsTriangle {

	/*
	 * (n,k) = (n-1,k-1)+(n-1,k) for any non-negative integer n and any integer
	 * k between 0 and n
	 */
	
	public static int[][] computeTriangle(int numberOfRows) {
		if (numberOfRows < 0)
			throw new IllegalArgumentException();
		int[][] rows = new int[numberOfRows][];
		for (int n = 0; n < numberOfRows; n++) {
			rows[n] = new int[n + 1];
			for (int k = 0; k <= n; k++) {
				if (n - 1 >= 0) {
					if (k - 1 >= 0 && k != n) {
						rows[n][k] = (rows[n - 1][k - 1] + rows[n - 1][k]);
					} else {
						rows[n][k] = 1;
					}
				} else {
					rows[n][k] = 1;
				}
			} // end of row
		} // end of array
		return rows;
	}

	public static boolean isTriangle(int[][] input) {
		int expected;
		for (int n = 0; n < input.length; n++) {
			for (int k = 0; k <= n; k++) {
				if (n - 1 >= 0) {
					if (k - 1 >= 0 && k != n) {
						expected = (input[n - 1][k - 1] + input[n - 1][k]);
					} else {
						expected = 1;
					}
				} else {
					expected = 1;
				}
				if (input[n][k] != expected)
					return false;
			} // end of row
		} // end of array
		return true;
	}
	/*
	public static int[][] commputeTriangle (int numberOfRows) {
		if (numberOfRows < 0) throw new IllegalArgumentException();
		int[][] rows = new int[numberOfRows][];
		for (int n = 0; n < numberOfRows; n++) {
			rows[n] = new int[n + 1];
			rows[0][0] = new OuterNode();
			for (int k = 0; k <= n; k++) {
				if (n - 1 >= 0) {
					if (k - 1 >= 0 && k != n) {
						rows[n][k] = (rows[n - 1][k - 1] + rows[n - 1][k]);
					} else {
						rows[n][k] = 1;
					}
				} else {
					rows[n][k] = 1;
				}
			} // end of row
		} // end of array
		
		return rows;
		
	}

	public static abstract class Node {

		abstract int getValue();
		
	}
	
	public static class OuterNode extends Node {
		
		public int getValue() {
			return 1;
		}
		
	}
	
	public static class InnerNode extends Node {
		
		private int value;
		
		public InnerNode (Node leftParent, Node rightParent) {
			this.value = leftParent.getValue() + rightParent.getValue();
		}
		
		public int getValue () {
			return this.value;
		}
	}
		
}
*/