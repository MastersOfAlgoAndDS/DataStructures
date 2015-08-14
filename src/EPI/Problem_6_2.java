/**
 * Problem 6.2 : Design an algorithm that takes a sequence of n three-dimensional
 * coordinates to be traversed, and returns the minimum battery capacity needed to
 * complete the journey. The robot begins with a fully charged battery.
 * */

package EPI;

public class Problem_6_2 {

	public static void main(String[] args) {
		// Take the input of the sequence of coordinates
		int[][] coords = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 }, { 4, 5, 6 } };
		Problem_6_2 p = new Problem_6_2();
		System.out
				.println("Minimum battery capacity required to complete this path: "
						+ p.findCapacity(coords));

	}

	int findCapacity(int[][] coords) {
		// Now Since only one dimension is of importance here, we're considering
		// it as Z and separating it to create a new list of z co-ordinates
		int[] zHeights = new int[coords.length];
		for (int i = 0; i < coords.length; i++) {
			zHeights[i] = coords[i][2];
		}
		int minHeight = Integer.MAX_VALUE;
		int minCapacity = Integer.MIN_VALUE;
		for (int height : zHeights) {
			minHeight = Math.min(minHeight, height);
			minCapacity = Math.max(minCapacity, height - minHeight);
		}
		return minCapacity;
	}
}
