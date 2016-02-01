package ctci_5E;

/**
 * @Problem_1_6 Given an image represented by an NxN matrix, where each pixel in
 *              the image is 4 bytes, write a method to rotate the image by 90
 *              degrees. Can you do this in place?
 * 
 *              Runtime: O(n^2) Space: O(n^2)
 * 
 * @author Milind
 *
 */
public class P1_6_RotateMatrix {

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
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		P1_6_RotateMatrix s = new P1_6_RotateMatrix();
		s.setMatrix(matrix);
		s.print();
		s.rotate("R");
		s.print();

	}

	private void rotate(String direction) {
		transpose();
		print();
		int[][] arr = getMatrix();
		int n = arr[0].length;

		if (direction == "L") {
			// Rotate left means to reverse all columns
			for (int i = 0; i < n; i++) {
				int j = 0, k = n - 1;
				while (j < k) {
					int temp = arr[j][i];
					arr[j][i] = arr[k][i];
					arr[k][i] = temp;
					j++;
					k--;
				}
			}
		} else {
			// Rotate left means to reverse all rows
			for (int i = 0; i < n; i++) {
				int j = 0, k = n - 1;
				while (j < k) {
					int temp = arr[i][j];
					arr[i][j] = arr[i][k];
					arr[i][k] = temp;
					j++;
					k--;
				}
			}
		}
		setMatrix(arr);
	}

	/**
	 * 
	 * Function to take transpose of a matrix. Important point here is to run
	 * inner loop less number of times.
	 * 
	 */
	private void transpose() {
		int[][] arr = getMatrix();
		int n = arr[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i != j) {
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
		setMatrix(arr);
	}
}
