package companies.dropbox;
public class Frenemy {

	int ans = 0;

	public static void main(String[] args) {
		char[][] matrix = new char[][] { { '-', 'F', 'E' }, { 'F', '-', 'F' },
				{ 'E', 'F', '-' } };
		Frenemy s = new Frenemy();
		int ans = s.isFrenemy(matrix, 0, 2, "EE");
		System.out.println(ans);
	}

	public int isFrenemy(char[][] matrix, int x, int y, String chain) {
		if (ans == 1) {
			return 1;
		} else if (chain.length() == 0 && x == y) {
			return 1;
		} else if (chain.length() == 0) {
			return 0;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[x][i] == chain.charAt(0)) {
				ans = isFrenemy(matrix, i, y, chain.substring(1));
				if (ans == 1) {
					return ans;
				}
			}
		}
		return ans;

	}

}
