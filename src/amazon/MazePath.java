/**
 * Problem to determine whether there exists a path from the 0,0 to Goal which
 * is cell with value 9.
 * 
 * 1. Use recursion
 * 2. If current cell is 1, explore further else return false
 * 3. Use boolean matrix of the same size as input to mark visited cells of value 1 as VISITED. [MEMOIZATION]
 * 
 * 
 * 
 **/

package amazon;

public class MazePath {
	static int m;
	static int n;
	static int[][] maze;
	static boolean[][] boolmaze;

	public static boolean findThePath(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return false;
		}
		if (maze[x][y] == 9) {
			return true;
		}
		if (maze[x][y] == 0) {
			return false;
		}
		if (boolmaze[x][y] == false) {
			if (maze[x][y] == 1) {
				boolmaze[x][y] = true;
			}
			if (findThePath(x - 1, y) == true)
				return true;
			if (findThePath(x, y + 1) == true)
				return true;
			if (findThePath(x + 1, y) == true)
				return true;
			if (findThePath(x, y - 1) == true)
				return true;
		}
		return false;
	}

	public static boolean isPath(int[][] grid) {
		boolmaze = new boolean[m][n];
		return findThePath(0, 0);
	}

	public static void main(String args[]) {
		// int[][] matrix = { { 1, 1, 1 }, { 9, 1, 1 }, { 0, 1, 0 } };
		// int[][] matrix = { { 1, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } };
		// int[][] matrix = { { 1, 0, 0 }, { 1, 0, 9 }, { 0, 0, 1 } };
		// int[][] matrix = { { 1, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } }; // true
		// int[][] matrix = { { 1, 0, 1 }, { 0, 0, 1 }, { 1, 9, 1 } }; // false
		// int[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 9 } }; // true
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 0, 9 } }; // false

		m = matrix.length;
		n = matrix[0].length;
		maze = matrix;
		// findPath(matrix);
		System.out.println(isPath(matrix));
	}
}
