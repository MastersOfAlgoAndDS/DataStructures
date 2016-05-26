/**
 * Problem 6.1 : Write a function that takes an array A and an index i into A, and
 * rearranges the elements such that all elements less than A[i] appear first, followed
 * by elements equal to A[i], followed by elements greater than A[i]. Your algorithm
 * should have O(1) space complexity and O(|A|) time complexity.
 * */

package EPI;

public class Problem_6_1_Pivot {

	public static void ourPivotAlgo(int[] arr, int index) {
		int[] array = arr;
		// first find the proper place of the element at index.
		int lessThanElems = 0;
		for (int i : arr) {
			if (i < arr[index]) {
				lessThanElems++;
			}
		}

		// then place the indexed element at its proper place.
		int temp = arr[index];
		arr[index] = arr[lessThanElems];
		arr[lessThanElems] = temp;
		int newPlace = lessThanElems;
		// have 2 pointers go up and down our element and if the element on left
		// is greater than element on right, then swap them.
		int left = newPlace - 1;
		int right = newPlace + 1;
		while (true) {
			if (arr[left] < arr[newPlace])
				left--;
			if (arr[right] > arr[newPlace])
				right++;
			if (arr[left] > arr[newPlace] && arr[right] < arr[newPlace]) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			if (left < 0 || right >= arr.length) {
				break;
			}
		}

		// print the array now
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {
		int[] arr = { 1, 25, 4, 19, 6, 7, 13, 2 };
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		ourPivotAlgo(arr, 5);
	}

}
