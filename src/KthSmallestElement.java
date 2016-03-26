/**
 * @author Milind
 * @Problem: To find the Kth smalles element from 2 sorted arrays.
 *
 * @Solution_1: O(m+n) merge two arrays and then get the kth smallest element at
 *              index k-1;
 * 
 * @Solution_2: O(k) Use the merging algorithm to traverse through the lists and
 *              increment the counter. As the counter reaches k, return the
 *              element from the list at which k was reached.
 *
 * @Solution_3: O(logm + logn) Use binary search method.
 */
public class KthSmallestElement {

	/**
	 * @param arr1
	 * @param arr2
	 * @param k
	 * @return
	 * @Runtime: O(k) worst case because the worst case is that the element is
	 *           present at the end of one of the lists.
	 * 
	 */
	public static int KthSmallestElementLinear(int[] arr1, int[] arr2, int k) {
		int answer = 0;
		int i = 0, j = 0;
		if (k > arr1.length + arr2.length)
			return -1;
		while ((i + j) < k) {
			if (i == arr1.length)
				return arr2[j];
			else if (j == arr2.length)
				return arr1[i];
			if (arr1[i] < arr2[j]) {
				if (i + j + 1 == k) {
					answer = arr1[i];
				}
				i++;
			} else {
				if (i + j + 1 == k) {
					answer = arr2[j];
				}
				j++;
			}
		}
		return answer;
	}

	public static int KthSmallestElementEfficient(int[] A, int[] B, int k) {
		if (A.length == 0) {
			return B[k - 1];
		} else if (B.length == 0) {
			return A[k - 1];
		}

		int lastA = A[A.length - 1];
		if (A.length + B.length == k) {
			return Math.max(lastA, B[B.length - 1]);
		} else if (A.length <= k && B[k - A.length] >= lastA) {
			return lastA;
		}
		int answer = -1;
		k = k - 1;
		int mid1 = k / 2;
		int mid2 = k - mid1;
		int step = k / 4;

		while (step > 0) {
			if (A[mid1 - 1] < B[mid2 - 1]) {
				mid1 += step;
				mid2 -= step;
			} else {
				mid1 -= step;
				mid2 += step;
			}
			step /= 2;
		}
		if (A[mid1 - 1] < B[mid2 - 1]) {
			answer = B[mid2 - 1];
		} else {
			answer = A[mid1 - 1];
		}
		return answer;
	}

	public static void main(String[] args) {
		// int[] arr1 = { 2, 4, 6 };
		// int[] arr2 = { 3, 5, 7 };
		int[] arr1 = { 2, 4, 6 };
		int[] arr2 = { 3, 5, 7 };
		System.out.println(KthSmallestElementLinear(arr1, arr2, 4));
		// System.out.println(KthSmallestElementEfficient(arr1, arr2, 2));
		System.out.println(findKthSmallest(2, arr1, arr2));
	}

	public static int findKthSmallest(int k, int[] A, int[] B) {
		// handle k bounds
		if (k < 1 || k > A.length + B.length) {
			return -1;
		}

		// handle special case
		if (A.length == 0) {
			return B[k - 1];
		} else if (B.length == 0) {
			return A[k - 1];
		}

		// search A[k1] in A and B[k2] in B such that k1 + k2 = k
		// A[k1] >= B[k2-1] & B[k2] >= A[k1-1];
		// k1 is from 0 to A.length and k1 <= k

		// handle case k1 = A.length
		int lastA = A[A.length - 1];
		if (A.length + B.length == k) {
			return Math.max(lastA, B[B.length - 1]);
		} else if (A.length <= k && B[k - A.length] >= lastA) {
			return lastA;
		}

		// start to find k1
		int start = 0;
		int end = Math.min(A.length - 1, k);

		while (start <= end) {
			int k1 = (start + end) / 2;
			int k2 = k - k1;

			// over capability of B
			if (k2 > B.length) {
				start = k1 + 1;
			} else if (k1 == 0) {
				if (A[k1] >= B[k2 - 1]) {
					return B[k2 - 1];
				} else {
					start = k1 + 1;
				}
			} else if (k2 == 0) {
				if (B[k2] >= A[k1 - 1]) {
					return A[k1 - 1];
				} else {
					end = k1 - 1;
				}
			} else if (k2 == B.length) {
				if (A[k1] >= B[k2 - 1]) {
					return Math.max(A[k1 - 1], B[k2 - 1]);
				} else if (A[k1] < B[k2 - 1]) {
					start = k1 + 1;
				}
			} else {

				if (A[k1] >= B[k2 - 1] && B[k2] >= A[k1 - 1]) {
					return Math.max(A[k1 - 1], B[k2 - 1]);
				} else if (A[k1] < B[k2 - 1]) {
					start = k1 + 1;
				} else {// A[k1-1] > B[k2]
					end = k1 - 1;
				}
			}
		}

		throw new IllegalArgumentException();

	}

}
