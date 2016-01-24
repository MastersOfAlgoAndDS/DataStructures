package azumo;

import java.util.Arrays;

/**
 * Class to find the minimum distance between the values given in an array
 * 
 * @author Milind
 *
 */
class MinDistance {

	public int solution(int[] A) {
		Arrays.sort(A);
		return A[1] - A[0];
	}

	public static void main(String[] args) {
		int[] A = { 8, 24, 3, 20, 1, 17 };
		MinDistance s = new MinDistance();
		System.out.println(s.solution(A));
	}
}