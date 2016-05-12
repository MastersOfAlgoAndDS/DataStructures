package google;

/**
 * @Problem: To find EquillibriumIndex. i.e. index in array for which the sum of
 *           all elements before the index = sum of all elements after the
 *           index. There can be multiple equillibrium index.
 * 
 * @author Milind
 * 
 * @Solution:
 * 
 *            1. O(n^2) For each index in the given array, run a for loop to
 *            check whether the sum of elements before the index = sum of
 *            elements after the index.
 *
 *            2. First run 1 loop and find total sum of elements. Assign it to
 *            the rightSum var. Then keep on iterating and keep track of leftSum
 *            and rightSum and keep updating as you go. When you find
 *            leftSum=rightSum, not the index and return.
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
