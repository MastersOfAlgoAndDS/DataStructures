package companies.azumo;

import java.util.Arrays;

/**
 * 
 * Check this problem whether it is minimum distance between consecutive numbers or any 2 numbers in the array.
 * Class to find the minimum distance between the values given in an array
 * 
 * @author Milind
 *
 */
class MinDistance {

	public int solution(int[] A) {

		if (A.length > 1) {
			Arrays.sort(A);
			return A[1] - A[0];
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = { 8, 24, 3, 20, 1, 19 };
		MinDistance s = new MinDistance();
		System.out.println(s.solution(A));
	}
}