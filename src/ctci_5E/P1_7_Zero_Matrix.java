package ctci_5E;

import java.util.HashSet;
import java.util.Set;

/**
 * @Problem_1_7 Write an algorithm such that if an element in an MxN matrix is
 *              0, its entire row and column are set to 0.
 * 
 * @Solution: Make a set of all the rows and columns which are zero and capture
 *            all the rows and columns containing the zero element. Then for
 *            every row in row numbers set and every column in column numbers
 *            set, make all the elements as zero.
 * 
 * @Runtime: O(m*n) since we traverse at least once through each element to get
 *           the zero rows and columns numbers. where m are rows and n are
 *           columns.
 * 
 *           TO improve the space efficiency we can use bit vector instead of
 *           sets.
 * 
 * @author Milind
 *
 */
public class P1_7_Zero_Matrix {

	private int[][] matrix;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void print() {
		int[][] arr = getMatrix();
		int n = arr[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		P1_7_Zero_Matrix s = new P1_7_Zero_Matrix();
		int[][] arr = { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 0 } };
		s.setMatrix(arr);
		s.print();
		System.out.println();
		s.makeZero();
		s.print();
	}

	private void makeZero() {
		// capture all zero containing rows and cols
		int[][] arr = getMatrix();
		int colCnt = arr[0].length;
		int rowCnt = arr.length;

		Set<Integer> zeroRows = new HashSet<Integer>();
		Set<Integer> zeroCols = new HashSet<Integer>();
		for (int i = 0; i < rowCnt; i++) {
			for (int j = 0; j < colCnt; j++) {
				if (arr[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}

		// now run loop on zeroRows to set all elements of those rows to zero
		for (Integer i : zeroRows) {
			for (int j = 0; j < colCnt; j++) {
				arr[i][j] = 0;
			}
		}

		// now run loop on zeroCols to set all elements of those cols to zero
		for (Integer j : zeroCols) {
			for (int i = 0; i < rowCnt; i++) {
				arr[i][j] = 0;
			}
		}
		setMatrix(arr);
	}
}
