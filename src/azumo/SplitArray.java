package azumo;

import java.util.Arrays;

/**
 * To split the array into 2 parts first containing some counts of given number
 * and second containing equal counts of values not equal to X
 * 
 * @author Milind
 *
 */
class SplitArray {

	public int solution(int X, int[] A) {
		int leftCnt = 0;
		int rightCnt = 0;
		int totalXCnt = 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == X)
				totalXCnt += 1;
		}

		rightCnt = A.length - totalXCnt;
		for (int i = 0; i < A.length; i++) {
			if (leftCnt == rightCnt) {
				index = i;
				break;
			}
			if (A[i] == X)
				leftCnt++;
			else
				rightCnt--;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] B = { 5, 5, 1, 7, 2, 3, 5 };
		int[] A = { 7, 6, 7, 10, 7, 12, 7, 14, 15 };
		SplitArray s = new SplitArray();
		System.out.println(s.solution(7, A));

	}
}