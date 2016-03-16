package amazon;

/**
 * Problem to determine whether there exists a path from the 0,0 to Goal which
 * is cell with value 9.
 * 
 * */
public class MazePath {
	static int m;
	static int n;
	static int[][] maze;

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
		if (findThePath(x - 1, y) == true)
			return true;
		if (findThePath(x, y + 1) == true)
			return true;
		if (findThePath(x + 1, y) == true)
			return true;
		if (findThePath(x, y - 1) == true)
			return true;
		if (maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	public static boolean isPath(int[][] grid) {
		return findThePath(0, 0);
	}

	public static void main(String args[]) {
		// int[][] matrix = { { 1, 1, 1 }, { 9, 1, 1 }, { 0, 1, 0 } };
		// int[][] matrix = { { 1, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } };
		int[][] matrix = { { 1, 0, 0 }, { 1, 0, 9 }, { 0, 0, 1 } };
		// int[][] matrix = { { 1, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } };

		m = matrix.length;
		n = matrix[0].length;
		maze = matrix;
		// findPath(matrix);
		System.out.println(isPath(matrix));
	}
}
