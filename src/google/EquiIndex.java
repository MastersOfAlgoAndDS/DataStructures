package google;

/**
 * @Problem: To find EquillibriumIndex. i.e. index in array for which the sum of
 *           all elements before the index = sum of all elements after the
 *           index. There can be multiple equillibrium index.
 * 
 * @author Milind
 *
 */
public class EquiIndex {
	/**
	 * Time complexity O(n^2)
	 * 
	 * @param A
	 * @return
	 */
	public int solution1(int[] A) {
		int N = A.length;

		for (int i = 0; i < N; i++) {
			int sum1 = 0;
			for (int j = 0; j < i; j++) {
				sum1 += A[j];
			}
			int sum2 = 0;
			for (int k = i + 1; k < N; k++) {
				sum2 += A[k];
			}
			if (sum1 == sum2)
				return i;
		}
		return -1;
	}

	/**
	 * Time complexity O(n)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		int N = A.length;
		int index = -1;
		int sumLeft = 0, sumRight = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += A[i];
		}

		for (int i = 0; i < N; i++) {
			sumRight = sum - sumLeft - A[i];
			if (sumLeft == sumRight) {
				return i;
			}
			sumLeft += A[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };
		EquiIndex s = new EquiIndex();
		System.out.println(s.solution(A));
	}

}
