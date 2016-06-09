package azumo;

import java.util.Arrays;

/**
 * To split the array into 2 parts first containing some counts of given number
 * X and second containing equal counts of values not equal to X
 * 
 * @author Milind
 *
 * @Solution: 1. First count the total number of instances of the given number X
 *            in the array.
 * 
 *            2. Then keep 2 counts, leftCount to count number of Xs in left
 *            array and rightCount to count number of elements not equal to X in
 *            the right array.
 * 
 *            3. As you traverse through the array again, update these counts on
 *            the conditions and then get the answer
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

		// MAIN LOGIC
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
		// int[] A = { 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		SplitArray s = new SplitArray();
		System.out.println(s.solution(7, A));

	}
}