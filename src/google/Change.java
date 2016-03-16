package google;

public class Change {

	public static int makeChange(int[] coins, int change, int start) {

		int numWays = 0;
		for (int i = start; i < coins.length; i++) {

			if (change - coins[i] == 0) {
				numWays++;
				continue;
			}

			if (i < coins.length) {
				numWays += makeChange(coins, change - coins[i], i + 1);
			}
		}

		return numWays;

	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4 };
		System.out.println(Change.makeChange(input, 4, 0));

	}
}