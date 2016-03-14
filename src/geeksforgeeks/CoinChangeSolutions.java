package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Milind
 * @Problem: Given a value N, if we want to make change for N cents, and we have
 *           infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how
 *           many ways can we make the change? The order of coins doesn’t
 *           matter.
 * 
 *           For example, for N = 4 and S = {1,2,3}, there are four solutions:
 *           {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10
 *           and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2},
 *           {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * 
 * @solution: this question boils down to optimal-substructure problem. 1)
 *            Optimal Substructure: To count total number solutions, we can
 *            divide all set solutions in two sets. 1) Solutions that do not
 *            contain mth coin (or Sm). 2) Solutions that contain at least one
 *            Sm. Let count(S[], m, n) be the function to count the number of
 *            solutions, then it can be written as sum of count(S[], m-1, n) and
 *            count(S[], m, n-Sm).
 * 
 */
public class CoinChangeSolutions {

	public static int count(int N, ArrayList<Integer> list) {
		if (N == 0) {
			return 1;
		} else if (N < 0) {
			return 0;
		} else if (list.size() <= 0 && N >= 1) {
			return 0;
		} else {
			ArrayList<Integer> newList = new ArrayList<>();
			newList.addAll(list);
			int removedNum = newList.remove(newList.size() - 1);
			return count(N - removedNum, list) + count(N, newList);
		}
	}

	public static void main(String[] args) {
		int N = 25;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(10);
		System.out.println(count(N, list));
	}
}
