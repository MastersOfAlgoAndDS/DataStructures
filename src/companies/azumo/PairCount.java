package companies.azumo;

import java.util.Arrays;

/**
 * To count the number of pairs contained in the array with A[P] = A[Q] and 0 <=
 * P < Q < N
 * 
 * @author Milind
 * @Problem: To count the number of pairs contained in the array with A[P] =
 *           A[Q] and 0 <= P < Q < N
 * 
 * @Solution: First of all sort the numbers. Then the numbers with same value
 *            will
 *
 */
class PairCount {

	public static int fact(int num) {
		if (num <= 1)
			return 1;
		else
			return num * fact(num - 1);
	}

	public int solution(int[] A) {
		Arrays.sort(A); // first sort and then find pairs
		int currNumber = A[0];
		int pairCnt = 0;
		int currNumCnt = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == currNumber) {
				currNumCnt++;
			} else {
				if (currNumCnt > 1) {
					pairCnt += (fact(currNumCnt) / (fact(currNumCnt - 2) * 2));
				}
				currNumber = A[i];
				currNumCnt = 1;
			}
		}
		pairCnt += (fact(currNumCnt) / (fact(currNumCnt - 2) * 2));
		return pairCnt;
	}

	public static void main(String[] args) {
		int[] A = { 33, 13, 93, 93, 93, 3 };
		PairCount s = new PairCount();
		System.out.println(s.solution(A));
	}
}