/**
 * Find equillibrium index in an array i.e.
 * Find an index in an array such that its prefix sum equals its suffix sum.
 * 
 * Link: http://blog.codility.com/2011/03/solutions-for-task-equi.html
 * */

package companies.LiveRamp;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Equi {
	/**
	 * 
	 * O(n^2) solution
	 * 
	 * @param A
	 * @return
	 */
	public int Solution(int[] A) {
		int N = A.length;
		int[] B = new int[A.length];
		for (int i = 0; i < N; i++) {
			int sumLeft = 0;
			int sumRight = 0;
			for (int j = 0; j < i; j++) {
				sumLeft += A[j];
			}
			for (int j = i + 1; j < N; j++) {
				sumRight += A[j];
			}
			if (sumLeft == sumRight)
				B[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (B[i] == 1)
				return i;

		}
		return -1;
	}

	/**
	 * 
	 * O(n) solution!!
	 * 
	 * @param arr
	 * @return
	 */
	public int CoolSolution(int arr[]) {
		int n = arr.length;
		if (n == 0)
			return -1;
		long sum = 0;
		int i;
		for (i = 0; i < n; i++)
			sum += (long) arr[i];

		long sum_left = 0;
		for (i = 0; i < n; i++) {
			long sum_right = sum - sum_left - (long) arr[i];
			if (sum_left == sum_right)
				return i;
			sum_left += (long) arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		Equi S = new Equi();
		int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };
		System.out.println(S.CoolSolution(A));
	}
}