package companies.LiveRamp;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	public int[] solution(int[] T) {
		int n = T.length;
		int capital = -1;
		for (int i = 0; i < n; i++) {
			if (T[i] == i)
				capital = i;
		}
		HashMap<Integer, LinkedList<Integer>> hash = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < n; i++) {
			if (!hash.containsKey(T[i])) {
				LinkedList<Integer> ll = new LinkedList<Integer>();
				ll.add(i);
				hash.put(T[i], ll);
			} else if (hash.containsKey(T[i])) {
				hash.get(T[i]).addLast(i);
			}
		}

		// get the cities and count
		int[] result = new int[T.length];
		int cnt = 1;
		int cityIter = capital;
		System.out.println(capital);
		for (Integer i : hash.get(cityIter)) {
			int cityCnt = 0;
			for (Integer j : hash.get(i)) {
				System.out.println(j);
				if (j == cityIter)
					continue;
				result[cnt] += 1;

				if (hash.containsKey(j)) {
					cityCnt += hash.get(j).size();
					cityIter = j;
				}
			}

			cnt++;
			// result[cnt] = hash.get(capital).size() - 1;

		}
		for (int i = 0; i < n - 1; i++)
			result[i] = result[i + 1];
		return result;
	}

	public static void main(String[] args) {
		int[] T = { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };
		Solution s = new Solution();
		int[] result = s.solution(T);
		for (int i : result)
			System.out.print(i + " ");
	}

}
